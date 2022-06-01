package com.example.quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String topicc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout math = findViewById(R.id.mathLayout);
        final LinearLayout eng = findViewById(R.id.englishLayout);
        final LinearLayout sci = findViewById(R.id.scienceLayout);
        final LinearLayout hist = findViewById(R.id.historyLayout);

        final Button startBtn = findViewById(R.id.startBtn);

        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicc = "math";

                math.setBackgroundResource(R.drawable.rbw1);

                eng.setBackgroundResource(R.drawable.rbw);
                sci.setBackgroundResource(R.drawable.rbw);
                hist.setBackgroundResource(R.drawable.rbw);

            }
        });

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicc = "english";

                eng.setBackgroundResource(R.drawable.rbw1);

                math.setBackgroundResource(R.drawable.rbw);
                sci.setBackgroundResource(R.drawable.rbw);
                hist.setBackgroundResource(R.drawable.rbw);
            }
        });

        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicc = "science";

                sci.setBackgroundResource(R.drawable.rbw1);

                eng.setBackgroundResource(R.drawable.rbw);
                math.setBackgroundResource(R.drawable.rbw);
                hist.setBackgroundResource(R.drawable.rbw);
            }
        });

        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topicc = "history";

                hist.setBackgroundResource(R.drawable.rbw1);

                eng.setBackgroundResource(R.drawable.rbw);
                math.setBackgroundResource(R.drawable.rbw);
                sci.setBackgroundResource(R.drawable.rbw);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(topicc.isEmpty()){
                    Toast.makeText(MainActivity.this, "select a topic", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", topicc);
                    startActivity(intent);
                }
            }
        });
    }
}