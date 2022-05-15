package com.ultimate.globalangles.ui.fragment.trips.views.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;

import java.util.ArrayList;
import java.util.List;

public class
CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    List<CategoryCheckData> list;

    public CategoryAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<GetCategoryData> dataList) {
        list.clear();
        for (GetCategoryData categoryData : dataList) {
            list.add(new CategoryCheckData(false, categoryData));
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_checkbox, parent, false);
        return new CategoryViewHolder(inflate, new CategoryViewListener() {
            @Override
            public void onCheckChange(CategoryCheckData data, boolean isCheck) {
                int i = list.indexOf(data);
                list.get(i).setCheck(isCheck);
            }
        });
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
