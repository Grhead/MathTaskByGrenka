package com.example.mathtaskbygrenka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView FunctionText;
    Button CheckBtn;
    Button NewBtn;
    EditText Answer;
    char symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FunctionText = (TextView) findViewById(R.id.CorrectOrNot);
        CheckBtn = (Button) findViewById(R.id.CheckBtn);
        NewBtn = (Button) findViewById(R.id.NewBtn);
        Answer = (EditText) findViewById(R.id.UserAnswer);

        Random rand = new Random();
        int FirstNumber = rand.nextInt(100);
        int SecondNumber = rand.nextInt(100);;

        int[] Sym = new int[] {'+', '-'};
        symbol = (char) Sym[rand.nextInt(2)];
        FunctionText.setText("" + FirstNumber + symbol + SecondNumber + " =");
        Intent relocate = new Intent(MainActivity.this, ResultActivity.class);
        int ResultNumber;
        if (symbol == '+'){
            ResultNumber = FirstNumber + SecondNumber;
        } else{
            ResultNumber = FirstNumber - SecondNumber;
        }
        CheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean CheckedResult;
                try {
                    Answer.getText().toString();
                    String valueStr = Answer.getText().toString();
                    int value;

                    if (valueStr.equals("")) {
                        Toast.makeText(MainActivity.this, "Вы ничего не ввели", Toast.LENGTH_SHORT).show();
                    } else {
                        value = Integer.parseInt(valueStr);
                        if (value == ResultNumber) {
                            CheckedResult = true;
                        } else {
                            CheckedResult = false;
                        }
                        relocate.putExtra("UserValue", CheckedResult);
                        relocate.putExtra("ValueInt", ResultNumber);

                    }
                    startActivity(relocate);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Некорректный код", Toast.LENGTH_SHORT).show();
                }

            }


        });
        NewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int FirstNumber = rand.nextInt(100);
                int SecondNumber = rand.nextInt(100);;
                int ResultNumber = FirstNumber + SecondNumber;
                symbol = (char) Sym[rand.nextInt(2)];
                FunctionText.setText("" + FirstNumber + symbol + SecondNumber + " =");
                Answer.setText("");
            }
        });

    }
}