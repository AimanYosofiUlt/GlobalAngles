package com.ultimate.globalangles.ui.fragment.register;

import static com.ultimate.globalangles.utilities.ValidateSt.EMAIL_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NAME_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_AGREE_TERMS_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_EMAIL_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;
import static com.ultimate.globalangles.utilities.ValidateSt.PASSWORD_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.PHONE_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.SMALL_PASSWORD_ERROR;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ultimate.globalangles.repository.repos.user.UserRepo;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.repository.server.responses.base.ResponsesCallBack;
import com.ultimate.globalangles.repository.server.responses.register.RegisterResponse;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import com.ultimate.globalangles.utilities.ValidateSt;
import com.ultimate.globalangles.utilities.state.CheckNetworkListener;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import javax.inject.Inject;

public class RegisterFragmentViewModel extends BaseViewModel {
    @Inject
    UserRepo userRepo;

    MutableLiveData<ResponseState> registerResponseStateMDL;
    MutableLiveData<ResponseState> validateResponseStateMDL;

    @Inject
    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
        registerResponseStateMDL = new MutableLiveData<>();
        validateResponseStateMDL = new MutableLiveData<>();
    }

    public void validateRegister(Context context, String name, String email, String password, String phone, boolean isUserAgreeTerms) {
        StateUtil
                .validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        if (name.trim().isEmpty()) {
                            validateResponseStateMDL.setValue(ResponseState.failureState(NAME_EMPTY_FILED_ERROR));
                            return false;
                        }

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

                        if (phone.trim().isEmpty()) {
                            validateResponseStateMDL.setValue(ResponseState.failureState(PHONE_EMPTY_FILED_ERROR));
                            return false;
                        }

                        if (!isUserAgreeTerms) {
                            validateResponseStateMDL.setValue(ResponseState.failureState(NOT_AGREE_TERMS_ERROR));
                            return false;
                        }

                        return true;
                    }
                })
                .checkNetwork(context, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        register(name, email, password, phone);
                    }

                    @Override
                    public void onDisconnect() {
                        validateResponseStateMDL.setValue(ResponseState.failureState(NO_INTERNET_CONNECTION));
                    }
                });
    }

    private void register(String name, String email, String password, String phone) {
        userRepo.register(name, email, password, phone, new ResponsesCallBack<RegisterResponse>() {
            @Override
            public void onSuccess(RegisterResponse response) {
                ValidateSt.bearerAccessToken = "Bearer " + response.getData().getAccessToken();
                registerResponseStateMDL.setValue(ResponseState.successState());
            }

            @Override
            public void onFailure(String state, String errors) {
                registerResponseStateMDL.setValue(ResponseState.failureState(errors));
            }
        });
    }
}