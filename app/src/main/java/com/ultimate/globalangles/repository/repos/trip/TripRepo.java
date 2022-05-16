package com.ultimate.globalangles.repository.repos.trip;

import android.util.Log;

import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.requests.create_trip.CreateTripPostBody;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.create_trip.CreateTripResponse;
import com.ultimate.globalangles.repository.server.responses.get_trips.GetTripsResponse;
import com.ultimate.globalangles.utilities.ValidateSt;

import javax.inject.Inject;

public class TripRepo extends BaseRepo {
    @Inject
    public TripRepo() {
    }

    public void createTrip(CreateTripPostBody postBody, ResponsesCallBack<CreateTripResponse> callBack) {
        api.createTrip(ValidateSt.bearerAccessToken,ValidateSt.languageCode, postBody)
                .enqueue(callBack);
    }

    public void getTrips(ResponsesCallBack<GetTripsResponse> callBack) {
        api.getTrips(ValidateSt.bearerAccessToken, ValidateSt.languageCode)
                .enqueue(callBack);
    }
}
