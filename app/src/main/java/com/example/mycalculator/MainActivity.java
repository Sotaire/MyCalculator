package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    TextView panel;
    private double result, firstNumber, secondNumber;
    private String operation;
    String intermediateNumber = "";
    boolean isOperation = false;

    private ArrayList <Integer> id = new ArrayList<>();
    private  int idLogic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        panel = findViewById(R.id.text);



        Button btnResult = findViewById(R.id.sendResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,ForResult.class);
                intent2.putExtra(ForResult.RESULT_KEY,panel.getText().toString());
                startActivity(intent2);
            }
        });
    }
    public void onClick_buttons(View view) {
        if (isOperation) {
            panel.setText("");
            result = 0;
            operation = null;
            secondNumber = 0;
            firstNumber = 0;
            intermediateNumber = "";
            isOperation = false;
        }

        switch (view.getId()) {
            case R.id.button0:
                intermediateNumber += "0";
                id.add(view.getId());
                break;
            case R.id.button1:
                intermediateNumber += "1";
                id.add(view.getId());
                break;

            case R.id.button2:
                intermediateNumber += "2";
                id.add(view.getId());
                break;

            case R.id.button3:
                intermediateNumber += "3";
                id.add(view.getId());
                break;
            case R.id.button4:
                intermediateNumber += "4";
                id.add(view.getId());
                break;

            case R.id.button5:
                intermediateNumber += "5";
                id.add(view.getId());
                break;

            case R.id.button6:
                intermediateNumber += "6";
                id.add(view.getId());
                break;

            case R.id.button7:
                intermediateNumber += "7";
                id.add(view.getId());
                break;

            case R.id.button8:
                intermediateNumber += "8";
                id.add(view.getId());
                break;

            case R.id.button9:
                intermediateNumber += "9";
                id.add(view.getId());
                break;

            case R.id.comma:
                intermediateNumber += ".";
                id.add(view.getId());
                break;
        }
        panel.setText(intermediateNumber);
    }

    public void onClick_buttonLogic(View view) {
        switch (view.getId()) {
            case R.id.plus:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "+";
                intermediateNumber = "";
                panel.setText("+");
                idLogic = view.getId();
                break;
            case R.id.minus:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "-";
                intermediateNumber = "";
                panel.setText("-");
                idLogic = view.getId();
                break;
            case R.id.multiply:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "*";
                intermediateNumber = "";
                panel.setText("*");
                idLogic = view.getId();
                break;
            case R.id.division:
                firstNumber = Double.parseDouble(intermediateNumber);
                operation = "/";
                intermediateNumber = "";
                panel.setText("/");
                idLogic = view.getId();
                break;
            case R.id.equal:
                secondNumber = Double.parseDouble(intermediateNumber);
                idLogic = view.getId();

                switch (operation) {
                    case "+":
                        result = firstNumber + secondNumber;
                        break;
                    case "-":
                        result = firstNumber - secondNumber;
                        break;
                    case "*":
                        result = firstNumber * secondNumber;
                        break;
                    case "/":
                        result = firstNumber / secondNumber;
                        break;
                }
                panel.setText(firstNumber + " " +operation + " " + secondNumber + "=" +  result + "");
                isOperation = true;
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("new","onSaveInstanceState");
        outState.putIntegerArrayList("id",id);
        outState.putInt("idLogic",idLogic);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("new", "onRestoreInstanceState");
        if (savedInstanceState != null) {
            for (int i : savedInstanceState.getIntegerArrayList("id")) {
                Button btn = findViewById(i);
                switch (btn.getId()) {
                    case R.id.button0:
                        intermediateNumber += "0";
                        break;
                    case R.id.button1:
                        intermediateNumber += "1";
                        break;

                    case R.id.button2:
                        intermediateNumber += "2";
                        break;

                    case R.id.button3:
                        intermediateNumber += "3";
                        break;
                    case R.id.button4:
                        intermediateNumber += "4";
                        break;

                    case R.id.button5:
                        intermediateNumber += "5";
                        break;

                    case R.id.button6:
                        intermediateNumber += "6";
                        break;

                    case R.id.button7:
                        intermediateNumber += "7";
                        break;

                    case R.id.button8:
                        intermediateNumber += "8";
                        break;

                    case R.id.button9:
                        intermediateNumber += "9";
                        break;

                    case R.id.comma:
                        intermediateNumber += ".";
                        break;
                }
                panel.setText(intermediateNumber);
            }
            int btnLogic = savedInstanceState.getInt("idLogic");
            Button btnLogic2 = findViewById(btnLogic);
            switch (btnLogic2.getId()) {
                case R.id.plus:
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "+";
                    intermediateNumber = "";
                    panel.setText("+");
                    break;
                case R.id.minus:
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "-";
                    intermediateNumber = "";
                    panel.setText("-");
                    break;
                case R.id.multiply:
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "*";
                    intermediateNumber = "";
                    panel.setText("*");
                    break;
                case R.id.division:
                    firstNumber = Double.parseDouble(intermediateNumber);
                    operation = "/";
                    intermediateNumber = "";
                    panel.setText("/");
                    break;
                case R.id.equal:
                    secondNumber = Double.parseDouble(intermediateNumber);
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("new","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("new","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("new","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("new","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("new","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("new","onDestroy");
    }


}