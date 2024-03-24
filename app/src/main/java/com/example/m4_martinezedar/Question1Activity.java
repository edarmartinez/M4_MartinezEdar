package com.example.m4_martinezedar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question1Activity extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        score = getIntent().getIntExtra("score", 0); // Get the score from the previous activity

        Button submitButton = findViewById(R.id.submitButton);
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedOption = findViewById(selectedOptionId);

                if (selectedOption.getText().equals("Paris")) {
                    score++; // Increment the score for a correct answer
                    Toast.makeText(Question1Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Question1Activity.this, Question2Activity.class);
                    intent.putExtra("score", score); // Pass the updated score to the next activity
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Question1Activity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Question1Activity.this, LosingActivity.class);
                    intent.putExtra("score", score); // Pass the score to the losing activity
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}