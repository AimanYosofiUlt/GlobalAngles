package com.ultimate.globalangles.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ultimate.globalangles.databinding.BottomSheetUserTypeBinding;
import com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type.UserTypeBSListener;

public abstract class BaseBottomSheet extends BottomSheetDialogFragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initObservers();
        initErrorObserver();
        initLoading();
        initEvent();
    }

    protected abstract void initEvent();

    protected abstract void initLoading();

    protected abstract void initErrorObserver();

    protected abstract void initObservers();
}