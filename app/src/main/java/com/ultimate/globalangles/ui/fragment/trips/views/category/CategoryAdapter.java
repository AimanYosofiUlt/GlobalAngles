package com.ultimate.globalangles.ui.fragment.trips.views.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.TripCateogries;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    List<TripCateogries> list;
    CategoryViewListener listener;

    public CategoryAdapter(CategoryViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<TripCateogries> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category, parent, false);
        return new CategoryViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
