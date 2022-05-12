package com.ultimate.globalangles.ui.fragment.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.ultimate.globalangles.databinding.FragmentLoginBinding;
import com.ultimate.globalangles.repository.server.responses.base.ResponseState;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.utilities.state.OnValidateListener;
import com.ultimate.globalangles.utilities.state.StateUtil;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<LoginFragmentViewModel> {
    FragmentLoginBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentLoginBinding.inflate(getLayoutInflater());


        return bd.getRoot();
    }


    @Override
    public void initEvent() {
        bd.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(bd.getRoot()).navigate(LoginFragmentDirections.actionLoginFragmentToHomeMainFragment());


                String email = bd.email.getText().toString();
                String password = bd.password.getText().toString();
                if (!viewModel.validateLogin(requireContext(),email,password).isEmpty()){
                    Toast.makeText(requireContext(), "some fields empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void initObservers() {
        viewModel.loginResponseStateMDL.observe(this, new Observer<ResponseState>() {
            @Override
            public void onChanged(ResponseState responseState) {
                if (responseState.isSuccessful()){
                    //do navigate
                }else {
                    //show error message
                    Toast.makeText(requireContext(), ""+responseState.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void initLoading() {

    }

    @Override
    public void initErrorObserver() {

    }
}


