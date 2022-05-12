package com.ultimate.globalangles.ui.fragment.terms;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class TermsFragmentViewModel extends BaseViewModel {
    @Inject
    public TermsFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}