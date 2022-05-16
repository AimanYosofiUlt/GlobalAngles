package com.ultimate.globalangles.ui.fragment.trip_edit.view.category_checkbox;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewCategoryCheckboxBinding;
import com.ultimate.globalangles.utilities.ValidateSt;

public class CategoryCBViewHolder extends RecyclerView.ViewHolder {
    CategoryCheckData data;
    CategoryCBViewListener listener;
    ViewCategoryCheckboxBinding bd;


    public CategoryCBViewHolder(@NonNull View itemView, CategoryCBViewListener listener) {
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