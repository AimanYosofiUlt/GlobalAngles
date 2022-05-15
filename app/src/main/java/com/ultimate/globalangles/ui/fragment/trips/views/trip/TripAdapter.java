package com.ultimate.globalangles.ui.fragment.trips.views.trip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripViewHolder> {
    List<String> list;
    TripViewListener listener;

    public TripAdapter(TripViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<String> list) {
        this.list = list;
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
