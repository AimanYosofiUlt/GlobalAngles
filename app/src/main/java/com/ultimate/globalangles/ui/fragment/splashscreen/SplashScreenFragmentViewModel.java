package com.ultimate.globalangles.ui.fragment.splashscreen;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class SplashScreenFragmentViewModel extends BaseViewModel {
    @Inject
    public SplashScreenFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}