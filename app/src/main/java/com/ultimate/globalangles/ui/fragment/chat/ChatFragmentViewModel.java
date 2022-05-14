package com.ultimate.globalangles.ui.fragment.chat;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChatFragmentViewModel extends BaseViewModel {
    @Inject
    public ChatFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}