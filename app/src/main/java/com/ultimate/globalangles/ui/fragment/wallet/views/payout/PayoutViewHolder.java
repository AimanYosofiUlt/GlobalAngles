package com.ultimate.globalangles.ui.fragment.wallet.views.payout;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewPayoutHistoryBinding;

public class PayoutViewHolder extends RecyclerView.ViewHolder {
    String data;
    PayoutViewListener listener;
    ViewPayoutHistoryBinding bd;


    public PayoutViewHolder(@NonNull View itemView, PayoutViewListener listener) {
        super(itemView);
        bd = ViewPayoutHistoryBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}