package com.ultimate.globalangles.ui.fragment.wallet;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class WalletFragmentViewModel extends BaseViewModel {
    @Inject
    public WalletFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}