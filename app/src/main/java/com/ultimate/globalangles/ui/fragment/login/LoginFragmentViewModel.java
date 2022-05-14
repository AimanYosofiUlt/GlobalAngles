package com.ultimate.globalangles.ui.fragment.login;

import static com.ultimate.globalangles.utilities.ValidateSt.EMAIL_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_EMAIL_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;
import static com.ultimate.globalangles.utilities.ValidateSt.PASSWORD_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.SMALL_PASSWORD_ERROR;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.user.UserRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.login.LoginResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.utilities.ValidateSt;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import javax.inject.Inject;

public class LoginFragmentViewModel extends BaseViewModel {
    @Inject
    UserRepo userRepo;

    MutableLiveData<ResponseState> loginResponseStateMDL;
    MutableLiveData<ResponseState> validateResponseStateMDL;

    @Inject
    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        loginResponseStateMDL = new MutableLiveData<>();
        validateResponseStateMDL = new MutableLiveData<>();
    }

    public void validateLogin(Context requireContext, String email, String password) {
        StateUtil.validate(new OnValidateListener() {
            @Override
            public boolean onValidate() {
                String emailPattern = "[a-zA-Z][a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (email.trim().isEmpty()) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(EMAIL_EMPTY_FILED_ERROR));
                    return false;
                } else if (!email.trim().matches(emailPattern)) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(NOT_EMAIL_ERROR));
                    return false;
                }

                if (password.trim().isEmpty()) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(PASSWORD_EMPTY_FILED_ERROR));
                    return false;
                } else if (password.trim().length() < 8) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(SMALL_PASSWORD_ERROR));
                    return false;
                }
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
                        validateResponseStateMDL.setValue(ResponseState.failureState(NO_INTERNET_CONNECTION));
                    }
                });
    }

    private void login(String email, String password) {
        userRepo.login(email, password, new ResponsesCallBack<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse response) {
                ValidateSt.bearerAccessToken = "Bearer " + response.getData().getAccessToken();
                loginResponseStateMDL.setValue(ResponseState.successState());
            }

            @Override
            public void onFailure(String state, String errors) {
                loginResponseStateMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }

    public void validateLoginViaFacebook(Context context) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        return OnValidateListener.super.onValidate();
                    }
                })
                .checkNetwork(context, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {

                    }

                    @Override
                    public void onDisconnect() {

                    }
                });
    }
}