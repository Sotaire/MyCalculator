package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ForResult extends AppCompatActivity {

    public static final  String RESULT_KEY = "result_key";
    public static String saved;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);


        Button btnCalculator = findViewById(R.id.openCalculator);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForResult.this,MainActivity.class);
                startActivity(intent);
            }
        });
        getData();
        Button btnresult = findViewById(R.id.sendText);
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.putExtra(intent3.EXTRA_TEXT,saved);
                intent3.setAction(Intent.ACTION_SEND);
                intent3.setType("text/plain");

                if (intent3.resolveActivity(getPackageManager()) != null){
                    startActivity(intent3);
                }
            }
        });
    }
    private void getData(){
        Intent intent2 =  getIntent();
        if (intent2 != null){
            TextView btnGetResult = findViewById(R.id.getResult);
            saved = intent2.getStringExtra(RESULT_KEY);
            btnGetResult.setText(btnGetResult.getText().toString() + " " + saved);
        }
    }
}