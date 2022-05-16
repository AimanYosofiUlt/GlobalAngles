package com.ultimate.globalangles.ui.fragment.trip_edit;

import static com.ultimate.globalangles.utilities.ValidateSt.NOT_AVAILABLE_WIGHT_TERMS_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentTripEditBinding;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsData;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.category_checkbox.CategoryCBAdapter;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerAdapter;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;
import com.ultimate.globalangles.utilities.LayoutUtil;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripEditFragment extends BaseFragment<TripEditFragmentViewModel> implements DatePickerDialog.OnDateSetListener {
    FragmentTripEditBinding bd;
    CategoryCBAdapter categoryCBAdapter;
    LocationSpinnerAdapter locationFromAdapter;
    LocationSpinnerAdapter locationToAdapter;

    boolean isEditMode = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentTripEditBinding.inflate(getLayoutInflater());
        isEditMode = TripEditFragmentArgs.fromBundle(getArguments()).getIsEditMode();
        return bd.getRoot();
    }

    @Override
    public void initEvent() {
        bd.header.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(requireParentFragment())
                        .popBackStack();
            }
        });

        bd.header.notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(requireParentFragment())
                        .navigate(TripEditFragmentDirections.actionTripEditToNotifications());
            }
        });

        bd.tripInfo.arrivalDateBtn.setOnClickListener(view -> LayoutUtil.showDatePickerDialog(requireContext()
                , (picker, year, month, dayOfMonth) -> {
                    @SuppressLint("DefaultLocale") String dateStr = String.format("%04d\\%02d\\%02d",
                            picker.getYear(),
                            picker.getMonth(),
                            picker.getDayOfMonth());

                    bd.tripInfo.arrivalDateTV.setText(dateStr);
                }));

        bd.tripInfo.receivingDateBtn.setOnClickListener(view -> LayoutUtil.showDatePickerDialog(requireContext()
                , (picker, year, month, dayOfMonth) -> {
                    @SuppressLint("DefaultLocale") String dateStr = String.format("%04d %02d %02d",
                            picker.getDayOfMonth(),
                            picker.getMonth(),
                            picker.getYear());

                    bd.tripInfo.receivingDateTV.setText(dateStr);
                }));

        bd.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int locationIdFrom = locationFromAdapter.getLocationId(bd.tripInfo.fromSpinner.getSelectedItemPosition());
                int locationIdTo = locationToAdapter.getLocationId(bd.tripInfo.toSpinner.getSelectedItemPosition());
                String availableWeight = bd.tripInfo.availableWightTV.getText().toString();
                String arrivalDate = bd.tripInfo.arrivalDateTV.getText().toString();
                String receivingDate = bd.tripInfo.receivingDateTV.getText().toString();
                String bookingRef = bd.tripInfo.availableWightTV.getText().toString();
                String lastName = bd.tripInfo.availableWightTV.getText().toString();
                ArrayList<Integer> categoriesIds = categoryCBAdapter.getCategoriesIds();
                //todo finish here the function parameters
                viewModel.validateEditTrip(requireContext(), isEditMode, locationIdFrom, locationIdTo, availableWeight, categoriesIds);
            }
        });
    }

    @Override
    public void initObservers() {
        viewModel.countriesMDL.observe(getViewLifecycleOwner(), new Observer<List<GetLocationsData>>() {
            @Override
            public void onChanged(List<GetLocationsData> locationsData) {
                ArrayList<LocationSpinnerData> list = new ArrayList<>();
                // list pass by reference
                viewModel.setLocationList(0, list, locationsData);
                locationFromAdapter = new LocationSpinnerAdapter(requireContext(), list);
                locationToAdapter = new LocationSpinnerAdapter(requireContext(), list);
                bd.tripInfo.fromSpinner.setAdapter(locationFromAdapter);
                bd.tripInfo.toSpinner.setAdapter(locationToAdapter);
            }


        });

        viewModel.getLocationsResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                //todo Handle Error From The Server
            }
        });

        viewModel.categoriesMDL.observe(getViewLifecycleOwner(), new Observer<List<GetCategoryData>>() {
            @Override
            public void onChanged(List<GetCategoryData> categoryData) {
                categoryCBAdapter.setList(categoryData);
            }
        });

        viewModel.getCategoriesResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                //todo Handle Error From The Server
            }
        });

        viewModel.addTripResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {

            }
        });
    }

    @Override
    public void initLoading() {
        if (isEditMode) {
            bd.header.titleTV.setText(getString(R.string.edit_trip));
            bd.editBtn.setText(getString(R.string.update_trip));
        } else {
            bd.header.titleTV.setText(getString(R.string.add_trip));
            bd.editBtn.setText(getString(R.string.add_trip));
        }

        categoryCBAdapter = new CategoryCBAdapter();
        bd.categories.categoryRV.setAdapter(categoryCBAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        bd.categories.categoryRV.setLayoutManager(layoutManager);

        viewModel.validateGetEditData(requireContext());
    }

    @Override
    public void initErrorObserver() {
        viewModel.validateEditTripMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                handleValidateError(responseState.getMessage());
            }
        });
    }

    private void handleValidateError(String message) {
        switch (message) {
            case NO_INTERNET_CONNECTION:
                Toast.makeText(requireContext(), getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                break;

            case NOT_AVAILABLE_WIGHT_TERMS_ERROR:
                bd.tripInfo.availableWightTV.setError(getString(R.string.no_available_wight_error));
                break;

            default:
                Log.d("RegisterFragment", "HandleValidateError: You forget to handle this error :" + message);
        }
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        bd.tripInfo.arrivalDateTV.setText(selectedDate);
    }
}


