package com.ultimate.globalangles.ui.fragment.trip_edit;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.categroy.CategoryRepo;
import com.ultimate.globalangles.repository.repos.location.LocationRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryResponse;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsData;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.utilities.ValidateSt;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import java.util.List;

import javax.inject.Inject;

public class TripEditFragmentViewModel extends BaseViewModel {
    @Inject
    CategoryRepo categoryRepo;

    @Inject
    LocationRepo locationRepo;

    MutableLiveData<ResponseState> getCategoriesResponseMDL;
    MutableLiveData<List<GetCategoryData>> categoriesMDL;


    MutableLiveData<ResponseState> getLocationsResponseMDL;
    MutableLiveData<List<GetLocationsData>> countriesMDL;

    @Inject
    public TripEditFragmentViewModel(@NonNull Application application) {
        super(application);
        getCategoriesResponseMDL = new MutableLiveData<>();
        categoriesMDL = new MutableLiveData<>();
        getLocationsResponseMDL = new MutableLiveData<>();
        countriesMDL = new MutableLiveData<>();
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
                        ResponseState responseState = ResponseState.failureState(ValidateSt.NO_INTERNET_CONNECTION);
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
}