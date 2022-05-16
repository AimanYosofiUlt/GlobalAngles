package com.ultimate.globalangles.ui.fragment.trips;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.location.LocationRepo;
import com.ultimate.globalangles.repository.repos.trip.TripRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsData;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsResponse;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.repository.server.responses.get_trips.GetTripsResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;
import com.ultimate.globalangles.utilities.ValidateSt;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TripsFragmentViewModel extends BaseViewModel {
    @Inject
    TripRepo tripRepo;

    @Inject
    LocationRepo locationRepo;

    MutableLiveData<ResponseState> getLocationsResponseMDL;
    MutableLiveData<List<LocationSpinnerData>> locationsMDL;

    MutableLiveData<ResponseState> getTripsResponseMDL;
    MutableLiveData<List<GetTripData>> tripsListMDL;

    @Inject
    public TripsFragmentViewModel(@NonNull Application application) {
        super(application);
        getLocationsResponseMDL = new MutableLiveData<>();
        locationsMDL = new MutableLiveData<>();
        getTripsResponseMDL = new MutableLiveData<>();
        tripsListMDL = new MutableLiveData<>();
    }

    public void validateGetTrips(Context context) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        return OnValidateListener.super.onValidate();
                    }
                })
                .checkNetwork(context, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        getLocationsForTrips();
                    }

                    @Override
                    public void onDisconnect() {
                        getTripsResponseMDL.setValue(ResponseState.failureState(ValidateSt.NO_INTERNET_CONNECTION));
                    }
                });
    }

    private void getLocationsForTrips() {
        locationRepo.getLocations(new ResponsesCallBack<GetLocationsResponse>() {
            @Override
            public void onSuccess(GetLocationsResponse response) {
                ArrayList<LocationSpinnerData> list = new ArrayList<>();
                // list pass by reference
                setLocationList(0, list, response.getData());
                locationsMDL.setValue(list);
                getTrips();
            }

            @Override
            public void onFailure(String state, String errors) {
                getLocationsResponseMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }

    public void setLocationList(int grade, ArrayList<LocationSpinnerData> list, List<GetLocationsData> dataList) {
        for (GetLocationsData data : dataList) {
            LocationSpinnerData spinnerData = new LocationSpinnerData(data.getId(), data.getName(), grade);
            list.add(spinnerData);
            if (data.getChildren() != null) {
                setLocationList(grade + 1, list, data.getChildren());
            }
        }
    }


    private void getTrips() {
        tripRepo.getTrips(new ResponsesCallBack<GetTripsResponse>() {
            @Override
            public void onSuccess(GetTripsResponse response) {
                tripsListMDL.setValue(response.getData().getData());
            }

            @Override
            public void onFailure(String state, String errors) {
                getTripsResponseMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }

}