package com.example.quizzes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

    private TextView questions;
    private TextView question;
    private AppCompatButton option1, option2, option3, option4;
    private AppCompatButton nextBtn;
    private Timer quizTimer;
    private int timeMin = 8;
    private int seconds = 0;

    private List<QuestionList> questionLists;
    private int currentQuestionPosition = 0;
    private String selectedOptionByUser = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView topicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        nextBtn = findViewById(R.id.nextBtn);

        final String getTopicc = getIntent().getStringExtra("selectedTopic");

        topicName.setText(getTopicc);
        questionLists = QuestionBank.getQuestions(getTopicc);

        questions.setText((currentQuestionPosition+1)+"/"+questionLists.size());
        questions.setText(questionLists.get(0).getQuestion());
        option1.setText(questionLists.get(0).getOption1());
        option2.setText(questionLists.get(0).getOption2());
        option3.setText(questionLists.get(0).getOption3());
        option4.setText(questionLists.get(0).getOption4());
        startTimer(timer);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.rbr);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.rbr);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.rbr);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.rbr);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
                else{
                    changeNextQuestion();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion() {
        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionLists.size()) {
            nextBtn.setText("Finish");
        }
        if(currentQuestionPosition < questionLists.size()) {
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.rbw2);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.rbw2);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.rbw2);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.rbw2);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition+1)+"/"+questionLists.size());
            questions.setText(questionLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionLists.get(currentQuestionPosition).getOption4());
        }

        else{
            Intent intent = new Intent(QuizActivity.this, QuizResult.class);
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getIncorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextView) {
        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(seconds == 0) {
                    timeMin--;
                    seconds = 59;
                }
                else if(seconds == 0 && timeMin == 0) {
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuizActivity.this, QuizResult.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(intent);
                    finish();
                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes = String.valueOf(timeMin);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1) {
                            finalMinutes = "0"+finalMinutes;
                        }

                        if(finalSeconds.length() == 1) {
                            finalSeconds = "0"+finalSeconds;
                        }

                        timerTextView.setText(finalMinutes+":"+finalSeconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private int getCorrectAnswers(){
        int correctAnswers = 0;
        for(int i = 0; i < questionLists.size(); i++) {
            final String getSelectedAnswer = questionLists.get(i).getSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(getSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getIncorrectAnswers(){
        int correctAnswers = 0;
        for(int i = 0; i < questionLists.size(); i++) {
            final String getSelectedAnswer = questionLists.get(i).getSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(!getSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer(){
        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        if(option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.rbg1);
            option1.setTextColor(Color.WHITE);
        }
        else if(option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.rbg1);
            option2.setTextColor(Color.WHITE);
        }
        else if(option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.rbg1);
            option3.setTextColor(Color.WHITE);
        }
        else if(option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.rbg1);
            option4.setTextColor(Color.WHITE);
        }
    }
}