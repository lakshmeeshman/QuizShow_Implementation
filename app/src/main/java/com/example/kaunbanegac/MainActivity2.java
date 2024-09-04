package com.example.kaunbanegac;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        score = getIntent().getIntExtra("score", 0);

        RadioGroup optionsGroup = findViewById(R.id.optionsGroup);
        Button submitBtn = findViewById(R.id.submitBtn);
        TextView scoreText = findViewById(R.id.scoreText);

        scoreText.setText("Score: " + score);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = optionsGroup.getCheckedRadioButtonId();
                RadioButton selectedOption = findViewById(selectedId);

                if (selectedOption != null) {
                    String selectedAnswer = selectedOption.getText().toString();

                    if (selectedAnswer.equals("Jupiter")) {
                        score += 100;
                        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                        intent.putExtra("score", score);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity2.this, "You Lost! Your score is " + score, Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity2.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    ;
}
