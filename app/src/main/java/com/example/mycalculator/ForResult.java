package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
     String saved = "" ;



    ArrayList<String> resultArray = new ArrayList<>();

    Adapter adapter = new Adapter();

    RecyclerView recyclerview;

    private static final int REQUEST = 42;

    int i1 = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        recyclerview = findViewById(R.id.recycle_view);

        recyclerview.setAdapter(adapter);


        Button btnCalculator = findViewById(R.id.openCalculator);
        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForResult.this,MainActivity.class);
                intent.putExtra(RESULT_KEY, saved);
                startActivityForResult(intent,REQUEST);
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

    public void share(String text) {
        final Intent intent = new Intent();
        intent.setAction(intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, text);
        startActivity(intent.createChooser(intent, saved));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST && resultCode == RESULT_OK){
            String text = data.getStringExtra(MainActivity.RETURN_RESULT);
            resultArray.add(text);
            for (int i = i1; i < resultArray.size(); i++){
                adapter.History(resultArray.get(i));
                i1+=1;
            }
        }
    }
}
