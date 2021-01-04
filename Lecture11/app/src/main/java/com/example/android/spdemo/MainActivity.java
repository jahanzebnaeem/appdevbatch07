package com.example.android.spdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = new SharedPref(this);
    }

    public void Save(View view) {
        EditText userName = (EditText) findViewById(R.id.etName);
        EditText password = (EditText) findViewById(R.id.etPassword);
        sharedPref.SaveData(userName.getText().toString(), password.getText().toString());
    }

    public void Load(View view) {
        String prefData = sharedPref.LoadData();
        Toast.makeText(getApplicationContext(), prefData, Toast.LENGTH_LONG).show();
    }
}