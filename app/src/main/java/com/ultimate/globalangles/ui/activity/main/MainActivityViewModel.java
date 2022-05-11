package com.ultimate.globalangles.ui.activity.main;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class MainActivityViewModel extends BaseViewModel {
    @Inject
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
}
