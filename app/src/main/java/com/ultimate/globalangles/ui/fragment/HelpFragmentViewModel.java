package com.ultimate.globalangles.ui.fragment;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class HelpFragmentViewModel extends BaseViewModel {
    @Inject
    public HelpFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}