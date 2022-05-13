package com.ultimate.globalangles.ui.fragment.help.views.help_question;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ultimate.globalangles.R;
import java.util.ArrayList;
import java.util.List;

public class HelpQuestionAdapter extends RecyclerView.Adapter<HelpQuestionViewHolder> {
    List<String> list;
    HelpQuestionViewListener listener;

    public HelpQuestionAdapter(HelpQuestionViewListener listener) {
        list = new ArrayList<>();
        this.listener = listener;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HelpQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_help_question ,parent,false);
        return new HelpQuestionViewHolder(inflate, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpQuestionViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}