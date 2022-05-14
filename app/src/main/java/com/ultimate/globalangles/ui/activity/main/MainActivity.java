package com.ultimate.globalangles.ui.activity.main;

import android.os.Bundle;

import com.ultimate.globalangles.databinding.ActivityMainBinding;
import com.ultimate.globalangles.ui.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainActivityViewModel> {
    ActivityMainBinding bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bd = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bd.getRoot());


    }

    @Override
    protected void initEvent() {

    }

    @Override
    public void initViewModel() {

    }

    @Override
    public void initObservers() {

    }

    @Override
    public void initErrorObservers() {

    }

    @Override
    public void initLoading() {

    }
}