package com.ultimate.globalangles.ui.fragment.register;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class RegisterFragmentViewModel extends BaseViewModel {
    @Inject
    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}