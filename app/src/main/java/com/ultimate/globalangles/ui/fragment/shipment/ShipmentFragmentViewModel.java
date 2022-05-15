package com.ultimate.globalangles.ui.fragment.shipment;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ShipmentFragmentViewModel extends BaseViewModel {
    @Inject
    public ShipmentFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}