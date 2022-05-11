package com.ultimate.globalangles.utilities;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.facebook.shimmer.ShimmerFrameLayout;

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
}
