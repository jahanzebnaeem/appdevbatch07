package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Button selectedButton = (Button) view;
//        selectedButton.setBackgroundColor(Color.RED);
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
//        Log.d("Button CellID", String.valueOf(cellID));
        PlayGame(cellID, selectedButton);
    }

    int activePlayer = 1;
    ArrayList<Integer> player1 = new ArrayList<Integer>();
    ArrayList<Integer> player2 = new ArrayList<Integer>();

    void PlayGame (int cellID, Button stdButton) {
        Log.d("Button CellID", String.valueOf(cellID));

        if (activePlayer == 1) {
            stdButton.setBackgroundColor(Color.GREEN);
            stdButton.setText("X");
            stdButton.setTextSize(20.0f);
            stdButton.setTextColor(Color.WHITE);
            player1.add(cellID);
            activePlayer = 2;
            AutoPlay();
        } else if (activePlayer == 2) {
            stdButton.setBackgroundColor(Color.BLUE);
            stdButton.setText("O");
            stdButton.setTextSize(20.0f);
            stdButton.setTextColor(Color.WHITE);
            player2.add(cellID);
            activePlayer = 1;
        }

        stdButton.setEnabled(false);
        GetWinner();
    }

    void GetWinner() {
        int winner = -1;

        // Row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        }

        // Row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        }

        // Row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }

        // Column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        }

        // Column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        }

        // Column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }

        // Diagnal right to left
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2;
        }

        // Diagnal left to right
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2;
        }

        // Winner
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_LONG).show();
            }
            if (winner == 2) {
                Toast.makeText(this, "Player 2 is the winner", Toast.LENGTH_LONG).show();
            }
        }
    }

    void AutoPlay() {
        ArrayList<Integer> randomSelect = new ArrayList<Integer>();

        for (int cellId = 1; cellId < 10; cellId++) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                randomSelect.add(cellId);
            }
        }

        Random random = new Random();
        int randomId = random.nextInt(randomSelect.size() - 0) + 0;
        int randomCellId = randomSelect.get(randomId);

        Button selectedButton;
        switch (randomCellId) {
            case 1:
                selectedButton = (Button) findViewById(R.id.btnTopLeft);
                break;
            case 2:
                selectedButton = (Button) findViewById(R.id.btnTopMid);
                break;
            case 3:
                selectedButton = (Button) findViewById(R.id.btnTopRight);
                break;
            case 4:
                selectedButton = (Button) findViewById(R.id.btnMidLeft);
                break;
            case 5:
                selectedButton = (Button) findViewById(R.id.btnMidMid);
                break;
            case 6:
                selectedButton = (Button) findViewById(R.id.btnMidRight);
                break;
            case 7:
                selectedButton = (Button) findViewById(R.id.btnBottomLeft);
                break;
            case 8:
                selectedButton = (Button) findViewById(R.id.btnBottomMid);
                break;
            case 9:
                selectedButton = (Button) findViewById(R.id.btnBottomRight);
                break;
            default:
                selectedButton = (Button) findViewById(R.id.btnTopLeft);
                break;
        }
        PlayGame(randomCellId, selectedButton);
    }
}