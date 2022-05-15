package com.ultimate.globalangles.ui.fragment.trips.views.category;

import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryData;

public class CategoryCheckData {
    private boolean isCheck = false;
    private GetCategoryData data;

    public CategoryCheckData(boolean isCheck, GetCategoryData data) {
        this.isCheck = isCheck;
        this.data = data;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public GetCategoryData getData() {
        return data;
    }

    public void setData(GetCategoryData data) {
        this.data = data;
    }
}
