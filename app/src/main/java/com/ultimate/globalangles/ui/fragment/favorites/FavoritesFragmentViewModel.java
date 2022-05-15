package com.ultimate.globalangles.ui.fragment.favorites;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class FavoritesFragmentViewModel extends BaseViewModel {
    @Inject
    public FavoritesFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}