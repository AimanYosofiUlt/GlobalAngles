package com.ultimate.globalangles.repository.repos.user;

import android.os.AsyncTask;

import com.ultimate.globalangles.repository.local.tables.user.User;
import com.ultimate.globalangles.repository.local.tables.user.UserDao;
import com.ultimate.globalangles.repository.repos.base.BaseRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;
import com.ultimate.globalangles.repository.server.responses.login.LoginUser;
import com.ultimate.globalangles.repository.server.responses.register.RegisterResponse;
import com.ultimate.globalangles.repository.server.responses.register.RegisterUser;
import com.ultimate.globalangles.utilities.ValidateSt;

import javax.inject.Inject;

public class UserRepo extends BaseRepo {
    @Inject
    UserDao userDao;

    @Inject
    public UserRepo() {
    }

    public void login(String email, String password, ResponsesCallBack<LoginResponse> callBack) {
        api.login(ValidateSt.languageCode, email, password).enqueue(new ResponsesCallBack<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {
                LoginUser userData = response.getData().getUser();
                User user = new User(userData.getId(), userData.getName(), userData.getEmail(), userData.getPhone());
                saveCurrentUser(user);
                callBack.onSuccess(response);
            }

            @Override
            public void onFailure(String state, String errors) {
                callBack.onFailure(state, errors);
            }
        });
    }

    private void saveCurrentUser(User user) {
        AsyncTask.execute(() -> {
            userDao.deleteCurrentUser();
            userDao.insert(user);
        });
    }

    public void register(String name, String email, String password, String phone, ResponsesCallBack<RegisterResponse> callBack) {
        // todo CHECK MEAN OF THE DUPLICATED  PARAMETER IN SERVER
        // todo CHECK IF THERE IS CHANCE TO CHANGE THE DESIGN AND APP CONFIRM PASSWORD
        api.register(ValidateSt.languageCode, name, name, email, password, password, phone)
                .enqueue(new ResponsesCallBack<RegisterResponse>() {
                    @Override
                    public void onSuccess(RegisterResponse response) {
                        RegisterUser userData = response.getData().getUser();
                        User user = new User(userData.getId(), userData.getName(), userData.getEmail(), userData.getPhone());
                        saveCurrentUser(user);
                        callBack.onSuccess(response);
                    }

                    @Override
                    public void onFailure(String state, String errors) {
                        callBack.onFailure(state, errors);
                    }
                });
    }
}
