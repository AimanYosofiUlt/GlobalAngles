package com.ultimate.globalangles.ui.fragment.addShipment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentAddShipmentBinding;
import com.ultimate.globalangles.databinding.FragmentWebviewAffiliateBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddShipmentFragment extends BaseFragment<AddShipmentFragmentViewModel> {

    FragmentAddShipmentBinding bd;
    product_imgs_viewPagerAdapter viewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentAddShipmentBinding.inflate(getLayoutInflater());

        initViews();


        return bd.getRoot();
    }

    private void initViews() {
        viewAdapter = new product_imgs_viewPagerAdapter(requireContext());
        bd.viewPager.setAdapter(viewAdapter);
        bd.dot2.setViewPager(bd.viewPager);


        bd.rdBackpack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    bd.rdImgBackpack.setColorFilter(Color.argb(255, 255, 255, 255));
                    bd.txtRdBackpack.setTextColor(Color.WHITE);
                    bd.rdCarryOn.setChecked(false);
                    bd.rdCheckIn.setChecked(false);
                }else {
                    bd.rdImgBackpack.setColorFilter(getContext().getResources().getColor(R.color.external_btn_color));
                    bd.txtRdBackpack.setTextColor(getResources().getColor(R.color.external_btn_color));
                }
            }
        });

        bd.rdCarryOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    bd.rdImgCarryon.setColorFilter(Color.argb(255, 255, 255, 255));
                    bd.txtCarryOn.setTextColor(Color.WHITE);
                    bd.rdBackpack.setChecked(false);
                    bd.rdCheckIn.setChecked(false);
                }else {
                    bd.txtCarryOn.setTextColor(getResources().getColor(R.color.external_btn_color));
                    bd.rdImgCarryon.setColorFilter(getContext().getResources().getColor(R.color.external_btn_color));
                }
            }
        });
        bd.rdCheckIn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    bd.rdImgCheckin.setColorFilter(Color.argb(255, 255, 255, 255));
                    bd.txtCheckIn.setTextColor(Color.WHITE);
                    bd.rdCarryOn.setChecked(false);
                    bd.rdBackpack.setChecked(false);
                }else {
                    bd.txtCheckIn.setTextColor(getResources().getColor(R.color.external_btn_color));
                    bd.rdImgCheckin.setColorFilter(getContext().getResources().getColor(R.color.external_btn_color));
                }
            }
        });

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
