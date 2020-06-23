package com.example.mycalculator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {

    TextView text;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.vh_text);
    }

    public void fill(String text1){
        text.setText(text1);
    }

}
