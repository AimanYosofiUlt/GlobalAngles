package com.ultimate.globalangles.ui.fragment.online_store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.databinding.FragmentOnlineStoreBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

import javax.annotation.Nullable;

public class OnlineStoreFragment extends BaseFragment<OnlineStoreViewModel> {

    FragmentOnlineStoreBinding bd;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentOnlineStoreBinding.inflate(getLayoutInflater());
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
