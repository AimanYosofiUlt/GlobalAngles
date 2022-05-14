package com.ultimate.globalangles.ui.fragment.trips;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class TripsFragmentViewModel extends BaseViewModel {
    @Inject
    public TripsFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}