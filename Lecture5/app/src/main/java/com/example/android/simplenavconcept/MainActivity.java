package com.example.android.simplenavconcept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username = "admin";
    String password = "1234";
    int age = 23;
    EditText etUsername;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
    }

    public void userValidate(View view) {
        if(etUsername.getText().toString().length() == 0 &&
                etPassword.getText().toString().length() == 0) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_LONG).show();

        } else {
            if (username.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString())) {
                Intent intent = new Intent(this, Home.class);
                intent.putExtra("username", username);
                intent.putExtra("age", age);
                startActivity(intent);
            } else {
                Toast.makeText(this, "username or password not match", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }
}