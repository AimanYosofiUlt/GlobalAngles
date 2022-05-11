package com.ultimate.globalangles.ui.fragment.addShipment;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AddShipmentFragmentViewModel extends BaseViewModel {

    @Inject
    public AddShipmentFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
