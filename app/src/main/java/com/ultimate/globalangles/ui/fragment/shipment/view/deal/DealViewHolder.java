package com.ultimate.globalangles.ui.fragment.shipment.view.deal;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewDealBinding;

public class DealViewHolder extends RecyclerView.ViewHolder {
    String data;
    DealViewListener listener;
    ViewDealBinding bd;


    public DealViewHolder(@NonNull View itemView, DealViewListener listener) {
        super(itemView);
        bd = ViewDealBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}