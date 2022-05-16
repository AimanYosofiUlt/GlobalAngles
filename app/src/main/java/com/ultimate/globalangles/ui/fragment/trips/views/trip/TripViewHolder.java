package com.ultimate.globalangles.ui.fragment.trips.views.trip;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewTripBinding;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.GetTripData;
import com.ultimate.globalangles.ui.fragment.trips.views.category.CategoryAdapter;
import com.ultimate.globalangles.ui.fragment.trips.views.category.CategoryViewListener;

public class TripViewHolder extends RecyclerView.ViewHolder {
    TripViewData data;
    TripViewListener listener;
    ViewTripBinding bd;
    CategoryAdapter categoryAdapter;


    public TripViewHolder(@NonNull View itemView, TripViewListener listener) {
        super(itemView);
        bd = ViewTripBinding.bind(itemView);
        this.listener = listener;

        init();
        initEvent();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(),
                LinearLayoutManager.HORIZONTAL,
                true);
        bd.categoryRV.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(new CategoryViewListener() {
        });
        bd.categoryRV.setAdapter(categoryAdapter);
    }

    public void bind(TripViewData data) {
        this.data = data;

        String fromName = data.getFromLocation().getName();
        bd.fromTV.setText(fromName);
        String toName = data.getToLocation().getName();
        bd.toTV.setText(toName);

        GetTripData tripData = data.getData();
        bd.arraiveTV.setText(tripData.gettripArriveDate());
        bd.waightTV.setText(tripData.getAvaliableWeight());

        //todo Here Where is the preorder and where is the shipment
        String productCountStr = String.valueOf(tripData.getProducts().size());
        bd.bottom.shimpentCountTV.setText(productCountStr);
        bd.bottom.preOrderCountTV.setText(productCountStr);

        categoryAdapter.setList(data.getData().getCateogries());
    }

    private void initEvent() {
        bd.bottom.datialsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onShowDetailReq(data);
            }
        });
    }
}