package com.ultimate.globalangles.ui.fragment.trips.views.category;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewCategoryBinding;
import com.ultimate.globalangles.repository.server.responses.get_one_trip.TripCateogries;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    TripCateogries data;
    CategoryViewListener listener;
    ViewCategoryBinding bd;


    public CategoryViewHolder(@NonNull View itemView, CategoryViewListener listener) {
        super(itemView);
        bd = ViewCategoryBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(TripCateogries data) {
        this.data = data;
        bd.nameTV.setText(data.getTitle());
    }

    private void initEvent() {

    }
}