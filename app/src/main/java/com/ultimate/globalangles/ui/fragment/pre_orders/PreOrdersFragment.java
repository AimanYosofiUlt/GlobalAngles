package com.ultimate.globalangles.ui.fragment.pre_orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ultimate.globalangles.databinding.FragmentPreOrdersBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

public class PreOrdersFragment extends BaseFragment<PreOrdersFragmentViewModel> {

    FragmentPreOrdersBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentPreOrdersBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initObservers() {

    }

    @Override
    public void initLoading() {

    }

    @Override
    public void initErrorObserver() {

    }
}
