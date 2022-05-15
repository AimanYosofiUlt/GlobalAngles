package com.ultimate.globalangles.ui.fragment.shipment_detail;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ShipmentDetailFragmentViewModel extends BaseViewModel {
    @Inject
    public ShipmentDetailFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}