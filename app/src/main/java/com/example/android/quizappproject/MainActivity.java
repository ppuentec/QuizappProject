package com.example.android.quizappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    int score = 0;
    int number_of_days = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Display quiz score
    public void displayQuizScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.quiz_score);
        scoreView.setText(getString(R.string.ScoreMessage) + score);
    }

    public void submitQuiz() {
        question1Result();
    }

    public void question1Result() {
        // Is the button now checked?
        RadioButton ans1Result = (RadioButton) findViewById(R.id.opt4ques1);
        boolean opt4ques1 = ans1Result.isChecked();
        if (ans1Result.isChecked()) {
            // Increase score in 1 point
            score = score + 1;
        }
        // if not continue to next question
        else {
            question2Result();
        }
    }

    public void question2Result() {
        CheckBox phobosCheckBox = (CheckBox) findViewById(R.id.Phobos_checkbox);
        boolean phobosIsChecked = phobosCheckBox.isChecked();
        if (phobosIsChecked) {
            CheckBox deimosCheckBox = (CheckBox) findViewById(R.id.Deimos_checkbox);
            boolean deimosIsChecked = deimosCheckBox.isChecked();
            if (deimosIsChecked) {
                score = score + 1;
                //if not continue to next question
            } else {
                question3Result();
            }
        }
    }

    private void question3Result() {
        int ans3Entered = 0;
        EditText number_of_days = (EditText) findViewById(R.id.Answers3);
        ans3Entered = Integer.valueOf(number_of_days.getText().toString());

        if (ans3Entered == 300) {
            score = score + 1;
        } else {
            question4Result();
        }
        ;
    }

    private void question4Result() {
        // Is the button now checked?

        RadioButton ans4Result = (RadioButton) findViewById(R.id.opt4ques4);
        boolean opt4ques4 = ans4Result.isChecked();
        if (ans4Result.isChecked()) {
            // Increase score in 1 point
            score = score + 1;
        }
        // if not continue to next question
        else {
            question5Result();
        }
    }

    private void question5Result() {
        EditText ans5 = (EditText) findViewById(R.id.Answers5);
        String ans5Entered = ans5.getText().toString();

        if (ans5Entered.equals("Andromeda")) {
            score = score + 1;
            displayQuizScore(score);
        } else {
            displayQuizScore(score);
        }
    }
}
