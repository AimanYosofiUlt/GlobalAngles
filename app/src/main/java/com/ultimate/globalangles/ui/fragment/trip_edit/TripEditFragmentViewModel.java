package com.ultimate.globalangles.ui.fragment.trip_edit;

import static com.ultimate.globalangles.utilities.ValidateSt.NOT_AVAILABLE_WIGHT_TERMS_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.categroy.CategoryRepo;
import com.ultimate.globalangles.repository.repos.location.LocationRepo;
import com.ultimate.globalangles.repository.repos.trip.TripRepo;
import com.ultimate.globalangles.repository.server.requests.create_trip.CreateTripPostBody;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.create_trip.CreateTripResponse;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryResponse;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsData;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TripEditFragmentViewModel extends BaseViewModel {
    @Inject
    CategoryRepo categoryRepo;

    @Inject
    LocationRepo locationRepo;

    @Inject
    TripRepo tripRepo;

    MutableLiveData<ResponseState> getCategoriesResponseMDL;
    MutableLiveData<List<GetCategoryData>> categoriesMDL;

    MutableLiveData<ResponseState> getLocationsResponseMDL;
    MutableLiveData<List<GetLocationsData>> countriesMDL;

    MutableLiveData<ResponseState> validateEditTripMDL;
    MutableLiveData<ResponseState> addTripResponseMDL;

    @Inject
    public TripEditFragmentViewModel(@NonNull Application application) {
        super(application);
        getCategoriesResponseMDL = new MutableLiveData<>();
        categoriesMDL = new MutableLiveData<>();
        getLocationsResponseMDL = new MutableLiveData<>();
        countriesMDL = new MutableLiveData<>();
        validateEditTripMDL = new MutableLiveData<>();
        addTripResponseMDL = new MutableLiveData<>();
    }

    public void validateGetEditData(Context requireContext) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        return OnValidateListener.super.onValidate();
                    }
                })
                .checkNetwork(requireContext, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        getLocations();
                        getCategory();
                    }

                    @Override
                    public void onDisconnect() {
                        ResponseState responseState = ResponseState.failureState(NO_INTERNET_CONNECTION);
                        getCategoriesResponseMDL.setValue(responseState);
                    }
                });
    }

    private void getLocations() {
        locationRepo.getLocations(new ResponsesCallBack<GetLocationsResponse>() {
            @Override
            public void onSuccess(GetLocationsResponse response) {
                countriesMDL.setValue(response.getData());
            }

            @Override
            public void onFailure(String state, String errors) {
                getLocationsResponseMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }

    private void getCategory() {
        categoryRepo.getCategory(new ResponsesCallBack<GetCategoryResponse>() {
            @Override
            public void onSuccess(GetCategoryResponse response) {
                categoriesMDL.setValue(response.getData());
            }

            @Override
            public void onFailure(String state, String errors) {
                getCategoriesResponseMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }

    public void validateEditTrip(Context context, boolean isEditMode, int locationIdFrom, int locationIdTo, String availableWeight, ArrayList<Integer> categoriesIds) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {

                        if (availableWeight.trim().equals("")) {
                            validateEditTripMDL.setValue(ResponseState.failureState(NOT_AVAILABLE_WIGHT_TERMS_ERROR));
                            return false;
                        }

                        return OnValidateListener.super.onValidate();
                    }
                })
                .checkNetwork(context, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        // todo finish the funcation call
//                        CreateTripPostBody postBody = new CreateTripPostBody();
                        if (isEditMode) {
//                        createTrip(postBody);
                        } else {
//                        updateTrip(postBody);
                        }
                    }

                    @Override
                    public void onDisconnect() {
                        validateEditTripMDL.setValue(ResponseState.failureState(NO_INTERNET_CONNECTION));
                    }
                });
    }

    private void createTrip(CreateTripPostBody postBody) {
        tripRepo.createTrip(postBody, new ResponsesCallBack<CreateTripResponse>() {
            @Override
            public void onSuccess(CreateTripResponse response) {
                addTripResponseMDL.setValue(ResponseState.successState());
            }

            @Override
            public void onFailure(String state, String errors) {
                addTripResponseMDL.setValue(ResponseState.failureState(errors));
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
}