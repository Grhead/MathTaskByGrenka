package com.example.mathtaskbygrenka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    Button AgainBtn;
    ImageView ImageTest;
    TextView AdminText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        boolean UserInput = getIntent().getBooleanExtra("UserValue", false);
        int Correct = getIntent().getIntExtra("ValueInt", 1);

        AgainBtn = (Button) findViewById(R.id.AgainBtn);
        ImageTest = (ImageView) findViewById(R.id.ImageTest);
        AdminText = (TextView) findViewById(R.id.AdminText);


        if (UserInput == true){
            ImageTest.setImageResource(R.drawable.correct);

        } else if (UserInput == false){
            ImageTest.setImageResource(R.drawable.incorrect);
            AdminText.setText("Correct answer: " + Correct);
        }
        Intent relocate = new Intent(ResultActivity.this, MainActivity.class);
        AgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(relocate);
            }
        });

    }
}