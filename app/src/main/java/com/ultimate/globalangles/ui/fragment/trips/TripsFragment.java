package com.ultimate.globalangles.ui.fragment.trips;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ultimate.globalangles.databinding.FragmentTripsBinding;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.trip_detail.TripDetailFragmentArgs;
import com.ultimate.globalangles.ui.fragment.trip_detail.TripDetailFragmentDirections;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;
import com.ultimate.globalangles.ui.fragment.trips.views.trip.TripAdapter;
import com.ultimate.globalangles.ui.fragment.trips.views.trip.TripViewData;
import com.ultimate.globalangles.ui.fragment.trips.views.trip.TripViewListener;

import java.util.List;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripsFragment extends BaseFragment<TripsFragmentViewModel> {
    FragmentTripsBinding bd;
    TripFragmentListener listener;

    TripAdapter tripAdapter;

    List<LocationSpinnerData> locations;

    public TripsFragment(TripFragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentTripsBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }


    @Override
    public void initEvent() {
        bd.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddTripReq();
            }
        });
    }

    @Override
    public void initObservers() {
        viewModel.getTripsResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                Log.d("TripsFragment", "onChanged: 46543: " + responseState.getMessage());
            }
        });

        viewModel.tripsListMDL.observe(getViewLifecycleOwner(), new Observer<List<GetTripData>>() {
            @Override
            public void onChanged(List<GetTripData> data) {
                Log.d("TripsFragment", "onChanged: 2382: " + data.size());
                tripAdapter.setList(data,locations);
            }
        });

        viewModel.getLocationsResponseMDL.observe(getViewLifecycleOwner(), new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                Log.d("TripsFragment", "onChanged: 46543: " + responseState.getMessage());
            }
        });

        viewModel.locationsMDL.observe(getViewLifecycleOwner(), new Observer<List<LocationSpinnerData>>() {
            @Override
            public void onChanged(List<LocationSpinnerData> locations) {
                TripsFragment.this.locations = locations;
            }
        });
    }

    @Override
    public void initLoading() {
        tripAdapter = new TripAdapter(new TripViewListener() {
            @Override
            public void onShowDetailReq(TripViewData data) {
                listener.onTripDetailShowReq(data);
            }
        });
        bd.tripsRV.setAdapter(tripAdapter);
        LinearLayoutManager layout = new LinearLayoutManager(requireContext());
        bd.tripsRV.setLayoutManager(layout);

        viewModel.validateGetTrips(requireContext());
    }

    @Override
    public void initErrorObserver() {

    }
}


