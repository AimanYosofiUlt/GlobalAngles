package com.ultimate.globalangles.ui.fragment.login;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class LoginFragmentViewModel extends BaseViewModel {
    @Inject
    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}