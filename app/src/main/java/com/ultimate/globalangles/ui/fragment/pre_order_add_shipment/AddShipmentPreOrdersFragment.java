package com.ultimate.globalangles.ui.fragment.pre_order_add_shipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ultimate.globalangles.databinding.FragmentAddShipmentPreOrderBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

public class AddShipmentPreOrdersFragment extends BaseFragment<AddShipmentPreOrdersFragmentViewModel> {

    FragmentAddShipmentPreOrderBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentAddShipmentPreOrderBinding.inflate(getLayoutInflater());
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
