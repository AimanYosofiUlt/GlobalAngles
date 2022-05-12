package com.ultimate.globalangles.ui.fragment.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.databinding.FragmentMenuBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

import javax.annotation.Nullable;

public class MenuFragment extends BaseFragment {

    FragmentMenuBinding bd;


    @javax.annotation.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @javax.annotation.Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentMenuBinding.inflate(getLayoutInflater());
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
