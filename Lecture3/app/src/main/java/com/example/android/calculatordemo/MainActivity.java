package com.example.android.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Global variable
    EditText ptNum1;
    EditText ptNum2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Value assignment
        ptNum1 = (EditText) findViewById(R.id.ptNumber1);
        ptNum2 = (EditText) findViewById(R.id.ptNumber2);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void calSum(View view) {
        // TODO: Add the values in number 1 and number 2
        // Show result to result control
        int a = Integer.parseInt(ptNum1.getText().toString());
        int b = Integer.parseInt(ptNum2.getText().toString());
        int c = a+b;
        tvResult.setText(String.valueOf(c));
    }
}