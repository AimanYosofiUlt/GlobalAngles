package com.ultimate.globalangles.ui.fragment.login;

import static com.ultimate.globalangles.utilities.ValidateSt.EMAIL_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_EMAIL_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;
import static com.ultimate.globalangles.utilities.ValidateSt.PASSWORD_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.SMALL_PASSWORD_ERROR;

import android.app.Application;
import android.content.Context;
import android.util.Log;

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
    MutableLiveData<ResponseState> validateResponseStateMDL;

    @Inject
    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        loginResponseStateMDL = new MutableLiveData<>();
    }

    public void validateLogin(Context requireContext, String email, String password) {
        StateUtil.validate(new OnValidateListener() {
            @Override
            public boolean onValidate() {
                if (email.isEmpty()) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(EMAIL_EMPTY_FILED_ERROR));
                    return false;
                } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+")) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(NOT_EMAIL_ERROR));
                    return false;
                }

                if (password.isEmpty()) {
                    validateResponseStateMDL.setValue(ResponseState.failureState(PASSWORD_EMPTY_FILED_ERROR));
                    return false;
                } else if (password.length() < 4) {
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
                loginResponseStateMDL.setValue(ResponseState.successState());
            }

            @Override
            public void onFailure(String state, String errors) {
                loginResponseStateMDL.setValue(ResponseState.failureState(errors));
                Log.d("errorMs : ","msg : "+errors);

            }
        });
    }
}