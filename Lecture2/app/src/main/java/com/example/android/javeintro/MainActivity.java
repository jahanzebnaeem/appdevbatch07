package com.example.android.javeintro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int a = 5;
        int b = 6;
        int c = a+b;
        c=++a;
        TextView addVal = (TextView) findViewById(R.id.hello);
        addVal.setText(""+c);
    }
}