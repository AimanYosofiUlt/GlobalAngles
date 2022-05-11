package com.ultimate.globalangles.ui.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ultimate.globalangles.R;
import com.ultimate.globalangles.ui.login.LoginViewModel;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel.getListData();
        viewModel.mlist.observe(this,mlist -> {
            if (mlist != null){
                Toast.makeText(this, "wignsidfn", Toast.LENGTH_SHORT).show();
            }
        });
    }
}