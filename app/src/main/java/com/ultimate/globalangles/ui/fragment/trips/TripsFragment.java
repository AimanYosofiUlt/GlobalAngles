package com.ultimate.globalangles.ui.fragment.trips;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.ultimate.globalangles.databinding.FragmentTripsBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TripsFragment extends BaseFragment<TripsFragmentViewModel> {
    FragmentTripsBinding bd;
    TripFragmentListener listener;

    public TripsFragment(TripFragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentTripsBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }


    @Override
    public void initEvent() {
        bd.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onAddTripReq();
            }
        });
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


