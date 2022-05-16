package com.ultimate.globalangles.ui.fragment.trips.views.trip;

import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;

import java.io.Serializable;

public class TripViewData implements Serializable {
    GetTripData data;
    LocationSpinnerData fromLocation;
    LocationSpinnerData toLocation;

    public TripViewData(GetTripData data) {
        this.data = data;
    }

    public GetTripData getData() {
        return data;
    }

    public void setData(GetTripData data) {
        this.data = data;
    }

    public LocationSpinnerData getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(LocationSpinnerData fromLocation) {
        this.fromLocation = fromLocation;
    }

    public LocationSpinnerData getToLocation() {
        return toLocation;
    }

    public void setToLocation(LocationSpinnerData toLocation) {
        this.toLocation = toLocation;
    }
}
