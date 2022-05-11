package com.ultimate.globalangles.repository.repos.user;

import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;

import javax.inject.Inject;

public class UserRepo extends BaseRepo {
    @Inject
    public UserRepo() {

    }

    public void login(String email, String password, ResponsesCallBack<LoginResponse> callBack) {
        api.login(email, password).enqueue(callBack);
    }
}
