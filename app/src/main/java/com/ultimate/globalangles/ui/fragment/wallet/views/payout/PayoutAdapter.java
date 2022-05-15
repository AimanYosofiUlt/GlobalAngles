package com.ultimate.globalangles.ui.fragment.wallet.views.payout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;

import java.util.ArrayList;
import java.util.List;

public class PayoutAdapter extends RecyclerView.Adapter<PayoutViewHolder> {
    List<String> list;
    PayoutViewListener listener;

    public PayoutAdapter(PayoutViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_payout_history, parent, false);
        return new PayoutViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PayoutViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}