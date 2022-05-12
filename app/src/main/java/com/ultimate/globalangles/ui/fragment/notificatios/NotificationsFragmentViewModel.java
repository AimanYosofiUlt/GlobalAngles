package com.ultimate.globalangles.ui.fragment.notificatios;

import android.app.Application;

import androidx.annotation.NonNull;
import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class NotificationsFragmentViewModel extends BaseViewModel {
    @Inject
    public NotificationsFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}