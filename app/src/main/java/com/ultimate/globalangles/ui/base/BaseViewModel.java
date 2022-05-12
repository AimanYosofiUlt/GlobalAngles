package com.ultimate.globalangles.ui.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BaseViewModel extends AndroidViewModel {

    @Inject
    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}
