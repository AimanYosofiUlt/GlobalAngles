package com.ultimate.globalangles.ui.fragment.trip_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentTripDetailBinding;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.trip_edit.TripEditFragmentDirections;
import com.ultimate.globalangles.ui.fragment.trips.views.category.CategoryAdapter;
import com.ultimate.globalangles.ui.fragment.trips.views.category.CategoryViewListener;
import com.ultimate.globalangles.ui.fragment.trips.views.trip.TripViewData;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripDetailFragment extends BaseFragment<TripDetailFragmentViewModel> {
    FragmentTripDetailBinding bd;
    TripViewData data;

    CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentTripDetailBinding.inflate(getLayoutInflater());
        data = TripDetailFragmentArgs.fromBundle(getArguments()).getTripData();
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

        bd.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment
                        .findNavController(requireParentFragment())
                        .navigate(
                                TripDetailFragmentDirections
                                        .actionTripDetailToTripEdit().setIsEditMode(true)
                        );
            }
        });
    }

    @Override
    public void initObservers() {

    }

    @Override
    public void initLoading() {
        bd.header.titleTV.setText(getString(R.string.trip_details));

        bd.info.fromTo.fromTV.setText(data.getFromLocation().getName());
        bd.info.fromTo.toTV.setText(data.getToLocation().getName());
        GetTripData tripData = this.data.getData();
        bd.info.arrivalDateTV.setText(tripData.gettripArriveDate());
        bd.info.receivingDateTV.setText(tripData.getTripDate());
        bd.info.availableWightTV.setText(tripData.getAvaliableWeight());

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,
                true);
        bd.category.categoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(new CategoryViewListener() {
        });
        bd.category.categoryRV.setAdapter(categoryAdapter);
        categoryAdapter.setList(data.getData().getCateogries());
    }

    @Override
    public void initErrorObserver() {

    }
}


