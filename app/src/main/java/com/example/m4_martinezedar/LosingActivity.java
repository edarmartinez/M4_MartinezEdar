package com.example.m4_martinezedar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LosingActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private Button tryAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);

        scoreTextView = findViewById(R.id.scoreTextView);
        tryAgainButton = findViewById(R.id.tryAgainButton);

        int score = getIntent().getIntExtra("score", 0); // Get the final score from the intent extras
        scoreTextView.setText("Your score: " + score);

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LosingActivity.this, Question1Activity.class);
                intent.putExtra("score", 0); // Reset the score when starting a new game
                startActivity(intent);
                finish();
            }
        });
    }
}