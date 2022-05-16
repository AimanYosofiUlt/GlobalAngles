package com.ultimate.globalangles.ui.fragment.trips.views.trip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.fragment.trip_edit.view.location.LocationSpinnerData;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {
    List<TripViewData> list;
    TripViewListener listener;

    public TripAdapter(TripViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<GetTripData> tempList, List<LocationSpinnerData> locations) {
        list.clear();

        for (GetTripData tripData : tempList) {
            TripViewData data = new TripViewData(tripData);
            boolean hasFromLocation = false;
            boolean hasToLocation = false;
            for (LocationSpinnerData location : locations) {
                if (location.getId() == tripData.getLocationIdTo()) {
                    data.setFromLocation(location);
                    hasFromLocation = true;
                    if(hasToLocation)
                        break;
                }

                if (location.getId() == tripData.getLocationIdFrom()) {
                    data.setToLocation(location);
                    hasToLocation = true;
                    if(hasFromLocation)
                        break;
                }
            }
            list.add(data);
        }

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_trip, parent, false);
        return new TripViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TripViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
