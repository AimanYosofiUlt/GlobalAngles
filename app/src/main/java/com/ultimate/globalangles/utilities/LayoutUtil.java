package com.ultimate.globalangles.utilities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.ultimate.globalangles.R;

public class LayoutUtil {
    public static void showShimmer(ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout) {
        constraintLayout.setVisibility(View.INVISIBLE);
        constraintLayout.setAlpha(0);
        shimmerFrameLayout.startShimmer();
    }

    public static void hideShimmer(ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout) {
        shimmerFrameLayout.animate().setDuration(200).alpha(0).withEndAction(() -> {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            constraintLayout.setVisibility(View.VISIBLE);
            constraintLayout.animate().setDuration(1000).alpha(1);
        });
    }

    public static void showDatePickerDialog(Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        final DatePicker picker = new DatePicker(context);
        new AlertDialog.Builder(context)
                .setView(picker)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onDateSetListener.onDateSet(picker, picker.getYear(), picker.getMonth(), picker.getDayOfMonth());
                    }
                })
                .create()
                .show();
    }
}