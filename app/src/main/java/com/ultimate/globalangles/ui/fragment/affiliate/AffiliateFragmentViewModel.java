package com.ultimate.globalangles.ui.fragment.affiliate;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AffiliateFragmentViewModel extends BaseViewModel {

    @Inject
    public AffiliateFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
