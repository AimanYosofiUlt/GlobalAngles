package com.ultimate.globalangles.ui.fragment.chat.views.chat;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    String data;
    MessageViewListener listener;
    ViewMessageBinding bd;


    public MessageViewHolder(@NonNull View itemView, MessageViewListener listener) {
        super(itemView);
        bd = ViewMessageBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}