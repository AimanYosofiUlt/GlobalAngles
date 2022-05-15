package com.ultimate.globalangles.ui.fragment.trip_edit;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class TripEditFragmentViewModel extends BaseViewModel {
    @Inject
    public TripEditFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}