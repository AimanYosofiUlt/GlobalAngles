package com.ultimate.globalangles.ui.fragment.chats;

import android.app.Application;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.ui.base.BaseViewModel;

import javax.inject.Inject;

public class ChatsFragmentViewModel extends BaseViewModel {
    @Inject
    public ChatsFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}