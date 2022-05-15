package com.ultimate.globalangles.ui.fragment.trip_detail;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class TripDetailFragmentViewModel extends BaseViewModel {
    @Inject
    public TripDetailFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}