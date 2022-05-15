package com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ultimate.globalangles.databinding.BottomSheetUserTypeBinding;
import com.ultimate.globalangles.ui.base.BaseBottomSheet;

public class UserTypeBottomSheet extends BaseBottomSheet {
    BottomSheetUserTypeBinding bd;
    UserTypeBSListener listener;

    public static final String SHIPPER_TYPE = "SHIPPER_TYPE";
    public static final String ANGLE_TYPE = "ANGLE_TYPE";

    public UserTypeBottomSheet(UserTypeBSListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = BottomSheetUserTypeBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }

    @Override
    protected void initEvent() {
        bd.shipperTypeBtn.setOnClickListener(view -> {
            listener.onUserTypeChose(SHIPPER_TYPE);
            dismiss();
        });

        bd.angleTypeBtn.setOnClickListener(view -> {
            listener.onUserTypeChose(ANGLE_TYPE);
            dismiss();
        });

        bd.closeBtn.setOnClickListener(view -> dismiss());
    }

    @Override
    protected void initLoading() {

    }

    @Override
    protected void initErrorObserver() {

    }

    @Override
    protected void initObservers() {

    }
}
