package com.ultimate.globalangles.repository.repos.categroy;

import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.get_category.GetCategoryResponse;
import com.ultimate.globalangles.utilities.ValidateSt;

import javax.inject.Inject;

public class CategoryRepo extends BaseRepo {
    @Inject
    public CategoryRepo() {

    }

    public void getCategory(ResponsesCallBack<GetCategoryResponse> callBack) {
        api.getCategories(ValidateSt.bearerAccessToken).enqueue(callBack);
    }
}
