package com.ultimate.globalangles.ui.fragment.trips;

import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.fragment.trips.views.trip.TripViewData;

public interface TripFragmentListener {
    void onAddTripReq();
    void onTripDetailShowReq(TripViewData data);
}
