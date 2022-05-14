package com.ultimate.globalangles.ui.fragment.deals;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class DealsFragmentViewModel extends BaseViewModel {
    @Inject
    public DealsFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}