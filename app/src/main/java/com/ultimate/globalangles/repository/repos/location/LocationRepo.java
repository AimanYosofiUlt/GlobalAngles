package com.ultimate.globalangles.repository.repos.location;

import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.get_locations.GetLocationsResponse;
import com.ultimate.globalangles.utilities.ValidateSt;

import javax.inject.Inject;

public class LocationRepo extends BaseRepo {
    @Inject
    public LocationRepo() {
    }

    public void getLocations(ResponsesCallBack<GetLocationsResponse> callBack) {
        api.getLocations(ValidateSt.bearerAccessToken, ValidateSt.languageCode)
                .enqueue(callBack);
    }
}
