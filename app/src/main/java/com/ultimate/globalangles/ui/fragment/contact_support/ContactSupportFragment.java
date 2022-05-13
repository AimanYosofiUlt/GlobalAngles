package com.ultimate.globalangles.ui.fragment.contact_support;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ultimate.globalangles.databinding.FragmentContactSupportBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;
import javax.annotation.Nullable;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ContactSupportFragment extends BaseFragment<ContactSupportFragmentViewModel> {
    FragmentContactSupportBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentContactSupportBinding.inflate(getLayoutInflater());
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