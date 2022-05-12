package com.ultimate.globalangles.ui.fragment.main;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class HomeMainFragmentViewModel extends BaseViewModel {

    @Inject
    public HomeMainFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
