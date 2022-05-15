package com.ultimate.globalangles.ui.fragment.login;

import static com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type.UserTypeBottomSheet.SHIPPER_TYPE;
import static com.ultimate.globalangles.utilities.ValidateSt.EMAIL_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_EMAIL_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;
import static com.ultimate.globalangles.utilities.ValidateSt.PASSWORD_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.SMALL_PASSWORD_ERROR;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentLoginBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type.UserTypeBottomSheet;

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
        bd.loginBtn.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(LoginFragmentDirections.actionLoginToHomeShipper());
            String email = bd.emailED.getText().toString();
            String password = bd.passwordED.getText().toString();
            showProgress(requireContext(), getString(R.string.login), getString(R.string.loading));
            viewModel.validateLogin(requireContext(), email, password);
        });

        bd.registerLink.setOnClickListener(view ->
                NavHostFragment.findNavController(requireParentFragment())
                        .navigate(R.id.actionLoginToRegister)
        );

        bd.facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.validateLoginViaFacebook(requireContext());
            }
        });
    }

    @Override
    public void initObservers() {
        viewModel.loginResponseStateMDL.observe(this, responseState -> {
            hideProgress();
            if (responseState.isSuccessful()) {
                showUserBottomSheet();
            } else {
                // todo HANDLE THE SERVER ERRORS
                Log.d("LoginFragment", "initObservers: 93827: " + responseState.getMessage());
                //do navigate
            }
        });
    }

    private void showUserBottomSheet() {
        UserTypeBottomSheet bottomSheet = new UserTypeBottomSheet(type -> {
//            if (type.equals(SHIPPER_TYPE)) {
//                NavHostFragment
//                        .findNavController(this)
//                        .navigate(LoginFragmentDirections.actionLoginToMainShipper());
//            } else {
//                NavHostFragment
//                        .findNavController(this)
//                        .navigate(LoginFragmentDirections.actionLoginToMainAngle());
//            }
        });

        bottomSheet.show(requireActivity().getSupportFragmentManager(), "UserType");
    }

    @Override
    public void initLoading() {

    }

    @Override
    public void initErrorObserver() {
        viewModel.validateResponseStateMDL.observe(getViewLifecycleOwner(), responseState -> {
            if (!responseState.isSuccessful()) {
                hideProgress();
                HandleValidateError(responseState.getMessage());
            }
        });
    }

    private void HandleValidateError(String message) {
        switch (message) {
            case NO_INTERNET_CONNECTION:
                Toast.makeText(requireContext(), getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                break;

            case EMAIL_EMPTY_FILED_ERROR:
                bd.emailED.setError(getString(com.ultimate.globalangles.R.string.empty_email_error));
                break;

            case NOT_EMAIL_ERROR:
                bd.emailED.setError(getString(com.ultimate.globalangles.R.string.not_email_error));
                break;

            case PASSWORD_EMPTY_FILED_ERROR:
                bd.passwordED.setError(getString(com.ultimate.globalangles.R.string.empty_password_error));
                break;

            case SMALL_PASSWORD_ERROR:
                bd.passwordED.setError(getString(com.ultimate.globalangles.R.string.small_password_error));
                break;

            default:
                Log.d("RegisterFragment", "HandleValidateError: You forget to handle this error :" + message);
        }
    }
}


