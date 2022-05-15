package com.ultimate.globalangles.ui.fragment.bottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ultimate.globalangles.databinding.BottomSheetAddNewItemBinding;
import com.ultimate.globalangles.databinding.BottomSheetAddPreOrderBinding;

public class AddPreOrderBottomSheetFragment extends BottomSheetDialogFragment {
    private static final String TAG = "AddPreOrderBottomSheetFr";

    BottomSheetAddPreOrderBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = BottomSheetAddPreOrderBinding.inflate(getLayoutInflater());

        doSomeActions();
        return bd.getRoot();
    }

    private void doSomeActions() {
        bd.closeBtn.setOnClickListener(v -> {
            this.dismiss();
        });
    }
}
