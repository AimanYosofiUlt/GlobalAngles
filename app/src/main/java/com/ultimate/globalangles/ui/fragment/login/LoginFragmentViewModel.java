package com.ultimate.globalangles.ui.fragment.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.user.UserRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import javax.inject.Inject;

public class LoginFragmentViewModel extends BaseViewModel {
    @Inject
    UserRepo userRepo;

    MutableLiveData<ResponseState> loginResponseStateMDL;

    @Inject
    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        loginResponseStateMDL = new MutableLiveData<>();
    }

    public void validateLogin(Context requireContext, String email, String password) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        if (email.isEmpty())
                            return false;

                        if (password.isEmpty())
                            return false;

                        return true;
                    }
                })
                .checkNetwork(requireContext, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        login(email, password);
                    }

                    @Override
                    public void onDisconnect() {

                    }
                });
    }

    private void login(String email, String password) {
        userRepo.login(email, password, new ResponsesCallBack<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {
                loginResponseStateMDL.setValue(ResponseState.successState());
            }

            @Override
            public void onFailure(String state, String errors) {
                loginResponseStateMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }
}