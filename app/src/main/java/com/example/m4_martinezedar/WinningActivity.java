package com.example.m4_martinezedar;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WinningActivity extends AppCompatActivity {

    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        scoreTextView = findViewById(R.id.scoreTextView);

        int score = getIntent().getIntExtra("score", 0); // Get the final score from the intent extras
        scoreTextView.setText("Your score: " + score);
    }
}