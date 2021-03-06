package com.ultimate.globalangles.ui.fragment.home_shipper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ultimate.globalangles.databinding.FragmentHomeShipperBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.R;
import com.ultimate.globalangles.ui.fragment.addShipment.AddShipmentFragment;
import com.ultimate.globalangles.ui.fragment.affiliate.AffiliateFragment;
import com.ultimate.globalangles.ui.fragment.bottomSheet.AddNewItemBottomSheetFragment;
import com.ultimate.globalangles.ui.fragment.home_shipper.HomeShipperFragmentViewModel;
import com.ultimate.globalangles.ui.fragment.menu.MenuFragment;

import javax.annotation.Nullable;

public class HomeShipperFragment extends BaseFragment<HomeShipperFragmentViewModel> implements BottomNavigationView.OnItemSelectedListener {

    FragmentHomeShipperBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentHomeShipperBinding.inflate(getLayoutInflater());

        bd.bottomNavigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        return bd.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        operateBottomNav();
    }

    private void operateBottomNav() {
        bd.bottomNavigationView.setSelectedItemId(R.id.menuFragment);
        bd.bottomNavigationView.getMenu().findItem(R.id.menuFragment).setChecked(true);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.shop){
            replacementFragments(new AddShipmentFragment());
        }else if (id == R.id.menuFragment){
            replacementFragments(new MenuFragment());
        }else if (id == R.id.chats){
            showBottomSheetDialog();
        }else  replacementFragments(new AffiliateFragment());

        return true;
    }

    private void showBottomSheetDialog() {
         BottomSheetDialogFragment bottomSheetDialog = new AddNewItemBottomSheetFragment();
         bottomSheetDialog.show(getChildFragmentManager(),bottomSheetDialog.getTag());
    }

    private void replacementFragments(Fragment fragment){
        try {
            FragmentManager fragmentManager = getChildFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_frame, fragment).commit();
        }catch (Exception e){e.getMessage();}
    }
}
