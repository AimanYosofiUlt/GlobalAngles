package com.ultimate.globalangles.ui.fragment.home_angle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.ultimate.globalangles.databinding.FragmentHomeAngleBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.home_angle.views.view_pager.MainViewPagerAdapter;
import com.ultimate.globalangles.ui.fragment.trips.TripFragmentListener;
import com.ultimate.globalangles.ui.fragment.trips.TripsFragment;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeAngleFragment extends BaseFragment<HomeAngleFragmentViewModel> {
    FragmentHomeAngleBinding bd;
    MainViewPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentHomeAngleBinding.inflate(getLayoutInflater());
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
        initFragmentAdapter();

        bd.mainVP.setAdapter(adapter);
        bd.mainVP.setUserInputEnabled(false);
    }

    private void initFragmentAdapter() {
        adapter = new MainViewPagerAdapter(requireParentFragment());
        adapter.addFragment(new TripsFragment(() -> NavHostFragment.findNavController(requireParentFragment())
                .navigate(HomeAngleFragmentDirections.actionHomeAngleTripEdit())));
    }

    @Override
    public void initErrorObserver() {

    }
}


