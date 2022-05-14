package com.ultimate.globalangles.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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