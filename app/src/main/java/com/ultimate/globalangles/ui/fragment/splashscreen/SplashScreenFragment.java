package com.ultimate.globalangles.ui.fragment.splashscreen;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentSplashscreenBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SplashScreenFragment extends BaseFragment<SplashScreenFragmentViewModel> {
    FragmentSplashscreenBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentSplashscreenBinding.inflate(getLayoutInflater());
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
        new CountDownTimer(100, 100) {
            @Override
            public void onFinish() {
                NavHostFragment.findNavController(requireParentFragment())
                        .navigate(R.id.actionSplashScreenToLogin);
            }

            @Override
            public void onTick(long l) {
            }
        }.start();
    }

    @Override
    public void initErrorObserver() {

    }
}


