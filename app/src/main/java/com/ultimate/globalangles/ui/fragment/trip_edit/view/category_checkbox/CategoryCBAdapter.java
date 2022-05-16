package com.ultimate.globalangles.ui.fragment.trip_edit.view.category_checkbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;

import java.util.ArrayList;
import java.util.List;

public class CategoryCBAdapter extends RecyclerView.Adapter<CategoryCBViewHolder> {
    List<CategoryCheckData> list;

    public CategoryCBAdapter() {
        list = new ArrayList<>();
    }

    public void setList(List<GetCategoryData> dataList) {
        list.clear();
        for (GetCategoryData categoryData : dataList) {
            list.add(new CategoryCheckData(false, categoryData));
        }
        notifyDataSetChanged();
    }

    public List<CategoryCheckData> getList() {
        return list;
    }

    @NonNull
    @Override
    public CategoryCBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_category_checkbox, parent, false);
        return new CategoryCBViewHolder(inflate, new CategoryCBViewListener() {
            @Override
            public void onCheckChange(CategoryCheckData data, boolean isCheck) {
                int i = list.indexOf(data);
                list.get(i).setCheck(isCheck);
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCBViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public ArrayList<Integer> getCategoriesIds() {
        ArrayList<Integer> idList = new ArrayList<>();
        for (CategoryCheckData categoryCheckData : list) {
            idList.add(categoryCheckData.getData().getId());
        }
        return idList;
    }
}
