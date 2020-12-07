package com.example.android.agecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etYOB;
    TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etYOB = findViewById(R.id.etYOB);
        tvAge = findViewById(R.id.tvAge);
    }

    public void CalculateAge(View view) {
        int YOB = Integer.parseInt(etYOB.getText().toString().trim());
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - YOB;

//        System.out.println(age);
        tvAge.setText("Your age is: " + age + " Years and in months : " + age * 12 + " and in days : " + age * 365);
    }
}