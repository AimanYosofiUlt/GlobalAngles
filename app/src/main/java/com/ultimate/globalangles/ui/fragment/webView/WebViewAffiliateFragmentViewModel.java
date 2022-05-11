package com.ultimate.globalangles.ui.fragment.webView;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class WebViewAffiliateFragmentViewModel extends BaseViewModel {

    @Inject
    public WebViewAffiliateFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}
