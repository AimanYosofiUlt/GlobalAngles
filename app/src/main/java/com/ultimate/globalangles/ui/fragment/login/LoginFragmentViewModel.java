package com.ultimate.globalangles.ui.fragment.login;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
    private static String errorMessage="";

    @Inject
    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        loginResponseStateMDL = new MutableLiveData<>();
    }

    public String validateLogin(Context requireContext, String email, String password) {
        errorMessage = "";
        StateUtil.validate(new OnValidateListener() {
                    @Override
                    public boolean onValidate() {
                        if (email.isEmpty()){
                            LoginFragmentViewModel.setErrorMessage("email is empty");
                            return false;}

                        if (password.isEmpty()) {
                            LoginFragmentViewModel.setErrorMessage("password is empty");
                        return false;}

                        return true;
                    }
                })
                .checkNetwork(requireContext, new CheckNetworkListener() {
                    @Override
                    public void onConnect() {
                        errorMessage = "";
                        login(email, password);
                    }

                    @Override
                    public void onDisconnect() {
                        Toast.makeText(requireContext, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                    }
                });
        return errorMessage;
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

    public static void setErrorMessage(String message){
        errorMessage = message;
    }
}