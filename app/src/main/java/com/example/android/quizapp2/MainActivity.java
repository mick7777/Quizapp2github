package com.example.android.quizapp2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onRadioButtonClicked(View view) {
        int answerOne = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_one_a:
                if (checked)
                    break;
            case R.id.question_one_b:
                if (checked)
                    break;
            case R.id.question_one_c:
                if (checked)
                    break;
        }
    }

    public void onRadioButtonClickedTwo(View view) {
        int answerTwo = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_two_a:
                if (checked)
                    break;
            case R.id.question_two_b:
                if (checked)
                    break;
            case R.id.question_two_c:
                if (checked)
                    break;
        }
    }

    public List getResults(View view) {

        String questionOne = "";
        RadioButton RadioButtonOneA = findViewById(R.id.question_one_a);
        RadioButton RadioButtonOneB = findViewById(R.id.question_one_b);
        RadioButton RadioButtonOneC = findViewById(R.id.question_one_c);
        boolean questionOneAChecked = RadioButtonOneA.isChecked();
        if (questionOneAChecked) {
            questionOne += 'a';
        }
        boolean questionOneBChecked = RadioButtonOneB.isChecked();
        if (questionOneBChecked) {
            questionOne += 'b';
        }
        boolean questionOneCChecked = RadioButtonOneC.isChecked();
        if (questionOneCChecked) {
            questionOne += 'c';
        }
        String questionTwo = "";
        RadioButton RadioButtonTwoA = findViewById(R.id.question_two_a);
        RadioButton RadioButtonTwoB = findViewById(R.id.question_two_b);
        RadioButton RadioButtonTwoC = findViewById(R.id.question_two_c);
        boolean questionTwoAChecked = RadioButtonTwoA.isChecked();
        if (questionTwoAChecked) {
            questionTwo += 'a';
        }
        boolean questionTwoBChecked = RadioButtonTwoB.isChecked();
        if (questionTwoBChecked) {
            questionTwo += 'b';
        }
        boolean questionTwoCChecked = RadioButtonTwoC.isChecked();
        if (questionTwoCChecked) {
            questionTwo += 'c';
        }

        EditText questionThreeText = (EditText) findViewById(R.id.input_question_three);
        String questionThree = questionThreeText.getText().toString().toUpperCase();
        EditText questionFourText = (EditText) findViewById(R.id.input_question_four);
        String questionFour = questionFourText.getText().toString().toUpperCase();
        String questionFive = "";
        CheckBox questionFiveA = (CheckBox) findViewById(R.id.question_five_checkbox_a);
        boolean questionFiveAChecked = questionFiveA.isChecked();
        if (questionFiveAChecked) {
            questionFive += 'a';
        }
        CheckBox questionFiveB = (CheckBox) findViewById(R.id.question_five_checkbox_b);
        boolean questionFiveBChecked = questionFiveB.isChecked();
        if (questionFiveBChecked) {
            questionFive += 'b';
        }
        CheckBox questionFiveC = (CheckBox) findViewById(R.id.question_five_checkbox_c);
        boolean questionFiveCChecked = questionFiveC.isChecked();
        if (questionFiveCChecked) {
            questionFive += 'c';
        }
        List<String> answers = new ArrayList<String>();
        answers.add(questionOne);
        answers.add(questionTwo);
        answers.add(questionThree);
        answers.add(questionFour);
        answers.add(questionFive);
        return answers;
    }


    public void verifyResults(View view) {
        List answers = getResults(view);
        boolean isTestIncomplete = answers.contains("");
        if (isTestIncomplete) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.testIncomplete), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
        else {
            int playerScore = 0;
            String questionOne = answers.get(0).toString();
            if (questionOne.equals("b")) {

                playerScore += 1;
            }
            String questionTwo = answers.get(1).toString();
            if (questionTwo.equals("a")) {
                playerScore += 1;
            }
            String questionThree = answers.get(2).toString();
            if (questionThree.equals("GUNS")) {
                playerScore += 1;
            }
            String questionFour = answers.get(3).toString();
            if (questionFour.equals("DUCK")) {
                playerScore += 1;
            }
            String questionFive = answers.get(4).toString();
            if (questionFive.equals("ac")) {
                playerScore += 1;
            }

            String pointNumber = String.valueOf(playerScore);
            String result = "Congratulations on finishing the Musical Quiz 2017.";
            result += "\n" + "You scored " + pointNumber + " points.";

            final Toast resultToast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
            resultToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);


            resultToast.show();
            new CountDownTimer(9000, 1000)
            {
                public void onTick(long millisUntilFinished) { resultToast.show();}
                public void onFinish() { resultToast.show();}
            }.start();
        }
    }
}