package com.example.m4_martinezedar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Question2Activity extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        score = getIntent().getIntExtra("score", 0);

        Button submitButton = findViewById(R.id.submitButton);
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedOption = findViewById(selectedOptionId);

                if (selectedOption.getText().equals("Mars")) {
                    score++;
                    Toast.makeText(Question2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Question2Activity.this, Question3Activity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Question2Activity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Question2Activity.this, LosingActivity.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}