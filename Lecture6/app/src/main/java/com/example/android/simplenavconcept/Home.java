package com.example.android.simplenavconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = (TextView) findViewById(R.id.tvDisplayName);
        Intent intent = getIntent();
//        username.setText(intent.getStringExtra("username"));
//        username.setText(Integer.toString(intent.getIntExtra("age", 0)));
        if (!intent.getStringExtra("key").equals("1234")) {
            finish();
        }
    }

    public void closeActivity(View view) {
        finish();
    }
}