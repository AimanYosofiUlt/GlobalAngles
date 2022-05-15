package com.ultimate.globalangles.ui.fragment.shipment.view.deal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealViewHolder> {
    List<String> list;
    DealViewListener listener;

    public DealAdapter(DealViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_deal, parent, false);
        return new DealViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
