package com.ultimate.globalangles.ui.fragment.trips.views.category;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewCategoryCheckboxBinding;
import com.ultimate.globalangles.utilities.ValidateSt;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    CategoryCheckData data;
    CategoryViewListener listener;
    ViewCategoryCheckboxBinding bd;


    public CategoryViewHolder(@NonNull View itemView, CategoryViewListener listener) {
        super(itemView);
        bd = ViewCategoryCheckboxBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(CategoryCheckData data) {
        this.data = data;
        boolean isLocalArabic = ValidateSt.languageCode.equals(ValidateSt.ARABIC);
        String title;
        if (isLocalArabic) {
            title = data.getData().getTranslations().get(0).getTitle();
        } else {
            title = data.getData().getTranslations().get(1).getTitle();
        }
        bd.checkBox.setText(title);
        bd.checkBox.setChecked(data.isCheck());
    }

    private void initEvent() {
        bd.checkBox.setOnCheckedChangeListener((compoundButton, b) ->
                listener.onCheckChange(data, bd.checkBox.isChecked()));
    }
}