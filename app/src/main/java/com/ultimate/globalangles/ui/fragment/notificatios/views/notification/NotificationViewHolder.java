package com.ultimate.globalangles.ui.fragment.notificatios.views.notification;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewNotificationBinding;

public class NotificationViewHolder extends RecyclerView.ViewHolder {
    String data;
    NotificationViewListener listener;
    ViewNotificationBinding bd;


    public NotificationViewHolder(@NonNull View itemView, NotificationViewListener listener) {
        super(itemView);
        bd = ViewNotificationBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}