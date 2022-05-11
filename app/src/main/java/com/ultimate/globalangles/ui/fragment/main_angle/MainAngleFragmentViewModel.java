package com.ultimate.globalangles.ui.fragment.main_angle;
import android.app.Application;
import androidx.annotation.NonNull;
import com.ultimate.globalangles.ui.base.BaseViewModel;
import javax.inject.Inject;

public class MainAngleFragmentViewModel extends BaseViewModel {
    @Inject
    public MainAngleFragmentViewModel(@NonNull Application application) {
        super(application);
    }
}