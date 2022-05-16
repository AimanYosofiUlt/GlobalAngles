package com.ultimate.globalangles.ui.fragment.trip_edit.view.location;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LocationSpinnerAdapter extends ArrayAdapter<LocationSpinnerData> {
    Context context;
    List<LocationSpinnerData> list;

    public LocationSpinnerAdapter(@NonNull Context context, List<LocationSpinnerData> list) {
        super(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        this.context = context;
        this.list = list;
    }

    public int getLocationId(int position){
        return list.get(position).getId();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = getCustomTextView(parent);
        label.setText(list.get(position).getName());
        return label;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = getCustomTextView(parent);
        LocationSpinnerData spinnerData = list.get(position);
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < spinnerData.getGrade(); i++) {
            text.append("\t\t");
        }
        text.append(spinnerData.getName());
        label.setText(text);
        return label;
    }

    private TextView getCustomTextView(ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        int px12 = ((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                12,
                parent.getContext().getResources().getDisplayMetrics()
        ));

        int px8 = ((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                12,
                parent.getContext().getResources().getDisplayMetrics()
        ));
        label.setPadding(px12, px8, px12, px8);

        return label;
    }


}
