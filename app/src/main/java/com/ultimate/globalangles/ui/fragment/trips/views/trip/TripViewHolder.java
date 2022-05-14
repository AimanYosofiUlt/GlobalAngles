package com.ultimate.globalangles.ui.fragment.trips.views.trip;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripViewHolder extends RecyclerView.ViewHolder {
    String data;
    TripViewListener listener;
    ViewTripBinding bd;


    public TripViewHolder(@NonNull View itemView, TripViewListener listener) {
        super(itemView);
        bd = ViewTripBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}