package com.ultimate.globalangles.ui.fragment.register;

import static com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type.UserTypeBottomSheet.SHIPPER_TYPE;
import static com.ultimate.globalangles.utilities.ValidateSt.EMAIL_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NAME_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_AGREE_TERMS_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NOT_EMAIL_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.NO_INTERNET_CONNECTION;
import static com.ultimate.globalangles.utilities.ValidateSt.PASSWORD_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.PHONE_EMPTY_FILED_ERROR;
import static com.ultimate.globalangles.utilities.ValidateSt.SMALL_PASSWORD_ERROR;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.databinding.FragmentRegisterBinding;
import com.ultimate.globalangles.ui.base.BaseFragment;
import com.ultimate.globalangles.ui.fragment.login.bottomsheets.user_type.UserTypeBottomSheet;

import javax.annotation.Nullable;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterFragment extends BaseFragment<RegisterFragmentViewModel> {
    FragmentRegisterBinding bd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bd = FragmentRegisterBinding.inflate(getLayoutInflater());
        return bd.getRoot();
    }

    @Override
    public void initEvent() {
        bd.registerBtn.setOnClickListener(view -> {
            String name = bd.nameED.getText().toString();
            String email = bd.emailED.getText().toString();
            String password = bd.passwordED.getText().toString();
            String phone = bd.phoneED.getText().toString();
            boolean isUserAgreeTerms = bd.agreeTermsCB.isChecked();
            showProgress(requireContext(), getString(R.string.register), getString(R.string.loading));
            viewModel.validateRegister(requireContext(), name, email, password, phone, isUserAgreeTerms);
        });
    }

    @Override
    public void initObservers() {
        viewModel.registerResponseStateMDL.observe(this, responseState -> {
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
            if (type.equals(SHIPPER_TYPE)) {
                NavHostFragment
                        .findNavController(this)
                        .navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeMainFragment());
            } else {
                NavHostFragment
                        .findNavController(this)
                        .navigate(RegisterFragmentDirections.actionRegisterToMainAngle());
            }
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
            case NAME_EMPTY_FILED_ERROR:
                bd.nameED.setError(getString(R.string.empty_name_error));
                break;

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

            case PHONE_EMPTY_FILED_ERROR:
                bd.phoneED.setError(getString(R.string.empty_phone_error));
                break;

            case NOT_AGREE_TERMS_ERROR:
                bd.agreeTermsCB.setError(getString(R.string.not_agree_terms_error));
                break;

            default:
                Log.d("RegisterFragment", "HandleValidateError: You forget to handle this error :" + message);
        }
    }
}


