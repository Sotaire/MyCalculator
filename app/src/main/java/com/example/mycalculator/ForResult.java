package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ForResult extends AppCompatActivity {

    public static final String RESULT_KEY = "result_key";
    public static String saved;

    Adapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        getData();

        Button btnCalculator = findViewById(R.id.openCalculator);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForResult.this, MainActivity.class);
                startActivity(intent);
            }
        });
         Button btnresult = findViewById(R.id.sendText);
         btnresult.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 share(saved);
           }
         });
          }

    private void getData () {
        Intent intent2 = getIntent();
        if (intent2 != null) {
            saved = intent2.getStringExtra(RESULT_KEY);
            adapter.History(saved);
        }
    }
            public void share (String text){
                final Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_TEXT, text);
                startActivity(intent.createChooser(intent, saved));
            }
}
