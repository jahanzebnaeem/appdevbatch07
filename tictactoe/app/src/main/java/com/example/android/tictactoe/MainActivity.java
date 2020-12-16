package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Button selectedButton = (Button) view;
        selectedButton.setBackgroundColor(Color.RED);
        int cellID = 0;
        switch (selectedButton.getId()) {
            case R.id.btnTopLeft:
                cellID = 1;
                break;
            case R.id.btnTopMid:
                cellID = 2;
                break;
            case R.id.btnTopRight:
                cellID = 3;
                break;
            case R.id.btnMidLeft:
                cellID = 4;
                break;
            case R.id.btnMidMid:
                cellID = 5;
                break;
            case R.id.btnMidRight:
                cellID = 6;
                break;
            case R.id.btnBottomLeft:
                cellID = 7;
                break;
            case R.id.btnBottomMid:
                cellID = 8;
                break;
            case R.id.btnBottomRight:
                cellID = 9;
                break;
        }
        Log.d("Button CellID", String.valueOf(cellID));
    }
}