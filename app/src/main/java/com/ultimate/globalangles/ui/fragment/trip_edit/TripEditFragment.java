package com.ultimate.globalangles.ui.fragment.trip_edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.ultimate.globalangles.databinding.FragmentTripEditBinding;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsData;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.trips.views.category.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripEditFragment extends BaseFragment<TripEditFragmentViewModel> {
    FragmentTripEditBinding bd;
    CategoryAdapter categoryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentTripEditBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initObservers() {
        viewModel.countriesMDL.observe(getViewLifecycleOwner(), new Observer<List<GetLocationsData>>() {
            @Override
            public void onChanged(List<GetLocationsData> locationsData) {
                Toast.makeText(requireContext(), "GetDataDone", Toast.LENGTH_SHORT).show();
                ArrayList<String> list = new ArrayList<>();
                // list pass by reference
                getLocationList(0, list, locationsData);

                bd.tripInfo.fromSpinner.setAdapter(new ArrayAdapter<String>(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list));
            }

            private void getLocationList(int grade, ArrayList<String> list, List<GetLocationsData> dataList) {
                for (GetLocationsData data : dataList) {
                    StringBuilder space = new StringBuilder();
                    for (int i = 0; i < grade; i++) {
                        space.append("\t\t");
                    }
                    list.add(space + data.getName());
                    if (data.getChildren() != null) {
                        getLocationList(grade + 1, list, data.getChildren());
                    }
                }
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
                categoryAdapter.setList(categoryData);
            }
        });

        viewModel.getCategoriesResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                //todo Handle Error From The Server
            }
        });
    }

    @Override
    public void initLoading() {
        categoryAdapter = new CategoryAdapter();

        bd.categories.categoryRV.setAdapter(categoryAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        bd.categories.categoryRV.setLayoutManager(layoutManager);

        viewModel.validateGetEditData(requireContext());
    }

    @Override
    public void initErrorObserver() {

    }
}


