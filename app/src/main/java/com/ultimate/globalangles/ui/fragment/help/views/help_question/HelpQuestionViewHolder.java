package com.ultimate.globalangles.ui.fragment.help.views.help_question;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ultimate.globalangles.databinding.ViewHelpQuestionBinding;

public class HelpQuestionViewHolder extends RecyclerView.ViewHolder {
    String data;
    HelpQuestionViewListener listener;
    ViewHelpQuestionBinding bd;


    public HelpQuestionViewHolder(@NonNull View itemView, HelpQuestionViewListener listener) {
        super(itemView);
        bd = ViewHelpQuestionBinding.bind(itemView);
        this.listener = listener;
        initEvent();
    }

    public void bind(String data) {
        this.data = data;

    }

    private void initEvent() {

    }
}