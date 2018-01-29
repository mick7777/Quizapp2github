package com.example.android.quizapp2;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /** variables for text questions*/
    int firstRandomTextQuestionNumber;
    int secondRandomTextQuestionNumber;
    String[] textQuestionsPool;
    /** variables for radio questions*/
    int firstRandomRadioQuestionNumber;
    int secondRandomRadioQuestionNumber;
    String[] radioQuestionsPool;
    /** variables for checkbox questions*/
    int firstRandomCheckboxQuestionNumber;
    String[] checkboxQuestionsPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        textQuestionsPool = res.getStringArray(R.array.textquestions_array);
        int numberOfTextQuestions = textQuestionsPool.length;
        Random rand = new Random();
        firstRandomTextQuestionNumber = rand.nextInt(numberOfTextQuestions);
        while (firstRandomTextQuestionNumber % 2 != 0){
            firstRandomTextQuestionNumber = rand.nextInt(numberOfTextQuestions);
        }
        secondRandomTextQuestionNumber = rand.nextInt(numberOfTextQuestions);
        while ((secondRandomTextQuestionNumber % 2 != 0) || secondRandomTextQuestionNumber == firstRandomTextQuestionNumber){
            secondRandomTextQuestionNumber = rand.nextInt(numberOfTextQuestions);
        }

        String firstRandomTextQuestion = textQuestionsPool[firstRandomTextQuestionNumber];
        TextView firstRandomTextQuestionTextView = (TextView) findViewById(R.id.first_random_text_question);
        firstRandomTextQuestionTextView.setText(firstRandomTextQuestion);

        String secondRandomTextQuestion = textQuestionsPool[secondRandomTextQuestionNumber];
        TextView secondRandomTextQuestionTextView = (TextView) findViewById(R.id.second_random_text_question);
        secondRandomTextQuestionTextView.setText(secondRandomTextQuestion);

/** a section responsible for randomizing and display of radio questions */
    /**get questions array and randomize questions*/

        radioQuestionsPool = res.getStringArray(R.array.radioquestions_array);
        int numberOfRadioQuestions = radioQuestionsPool.length;

        firstRandomRadioQuestionNumber = rand.nextInt(numberOfRadioQuestions);
        while (firstRandomRadioQuestionNumber % 5 != 0){
            firstRandomRadioQuestionNumber = rand.nextInt(numberOfRadioQuestions);
        }
        secondRandomRadioQuestionNumber = rand.nextInt(numberOfRadioQuestions);
        while ((secondRandomRadioQuestionNumber % 5 != 0) || secondRandomRadioQuestionNumber == firstRandomRadioQuestionNumber){
            secondRandomRadioQuestionNumber = rand.nextInt(numberOfRadioQuestions);
        }
        /** display the question text and possible answers*/
        /** first random radio question*/
        String firstRandomRadioQuestion = radioQuestionsPool[firstRandomRadioQuestionNumber];
        TextView firstRandomRadioQuestionTextView = (TextView) findViewById(R.id.first_random_radio_question);
        firstRandomRadioQuestionTextView.setText(firstRandomRadioQuestion);

        String firstRandomRadioA = radioQuestionsPool[firstRandomRadioQuestionNumber+1];
        TextView firstRandomRadioQuestionA = (TextView) findViewById(R.id.radio_one_a);
        firstRandomRadioQuestionA.setText(firstRandomRadioA);

        String firstRandomRadioB = radioQuestionsPool[firstRandomRadioQuestionNumber+2];
        TextView firstRandomRadioQuestionB = (TextView) findViewById(R.id.radio_one_b);
        firstRandomRadioQuestionB.setText(firstRandomRadioB);

        String firstRandomRadioC = radioQuestionsPool[firstRandomRadioQuestionNumber+3];
        TextView firstRandomRadioQuestionC = (TextView) findViewById(R.id.radio_one_c);
        firstRandomRadioQuestionC.setText(firstRandomRadioC);

        /** second random radio question*/
        String secondRandomRadioQuestion = radioQuestionsPool[secondRandomRadioQuestionNumber];
        TextView secondRandomRadioQuestionTextView = (TextView) findViewById(R.id.second_random_radio_question);
        secondRandomRadioQuestionTextView.setText(secondRandomRadioQuestion);

        String secondRandomRadioA = radioQuestionsPool[secondRandomRadioQuestionNumber+1];
        TextView secondRandomRadioQuestionA = (TextView) findViewById(R.id.radio_two_a);
        secondRandomRadioQuestionA.setText(secondRandomRadioA);

        String secondRandomRadioB = radioQuestionsPool[secondRandomRadioQuestionNumber+2];
        TextView secondRandomRadioQuestionB = (TextView) findViewById(R.id.radio_two_b);
        secondRandomRadioQuestionB.setText(secondRandomRadioB);

        String secondRandomRadioC = radioQuestionsPool[secondRandomRadioQuestionNumber+3];
        TextView secondRandomRadioQuestionC = (TextView) findViewById(R.id.radio_two_c);
        secondRandomRadioQuestionC.setText(secondRandomRadioC);

/** a section responsible for randomizing and display of checkbox questions */
/**get questions array and randomize questions*/

        checkboxQuestionsPool = res.getStringArray(R.array.checkboxquestions_array);
        int numberOfCheckboxQuestions = checkboxQuestionsPool.length;

        firstRandomCheckboxQuestionNumber = rand.nextInt(numberOfCheckboxQuestions);
        while (firstRandomCheckboxQuestionNumber % 5 != 0){
            firstRandomCheckboxQuestionNumber = rand.nextInt(numberOfCheckboxQuestions);
        }

        /** display the question text and possible answers*/
        /** first random radio question*/
        String firstRandomCheckboxQuestion = checkboxQuestionsPool[firstRandomCheckboxQuestionNumber];
        TextView firstRandomCheckboxQuestionTextView = (TextView) findViewById(R.id.first_random_checkbox_question);
        firstRandomCheckboxQuestionTextView.setText(firstRandomCheckboxQuestion);

        String firstRandomCheckboxA = checkboxQuestionsPool[firstRandomCheckboxQuestionNumber+1];
        TextView firstRandomCheckboxQuestionA = (TextView) findViewById(R.id.checkbox_one_a);
        firstRandomCheckboxQuestionA.setText(firstRandomCheckboxA);

        String firstRandomCheckboxB = checkboxQuestionsPool[firstRandomCheckboxQuestionNumber+2];
        TextView firstRandomCheckboxQuestionB = (TextView) findViewById(R.id.checkbox_one_b);
        firstRandomCheckboxQuestionB.setText(firstRandomCheckboxB);

        String firstRandomCheckboxC = checkboxQuestionsPool[firstRandomCheckboxQuestionNumber+3];
        TextView firstRandomCheckboxQuestionC = (TextView) findViewById(R.id.checkbox_one_c);
        firstRandomCheckboxQuestionC.setText(firstRandomCheckboxC);

    }


    public void onRadioButtonClicked(View view) {
        int answerOne = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_one_a:
                if (checked)
                    break;
            case R.id.radio_one_b:
                if (checked)
                    break;
            case R.id.radio_one_c:
                if (checked)
                    break;
        }
    }

    public void onRadioButtonClickedTwo(View view) {
        int answerTwo = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_two_a:
                if (checked)
                    break;
            case R.id.radio_two_b:
                if (checked)
                    break;
            case R.id.radio_two_c:
                if (checked)
                    break;
        }
    }

    public List getResults(View view) {

        String questionOne = "";
        RadioButton RadioButtonOneA = findViewById(R.id.radio_one_a);
        RadioButton RadioButtonOneB = findViewById(R.id.radio_one_b);
        RadioButton RadioButtonOneC = findViewById(R.id.radio_one_c);
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
        RadioButton RadioButtonTwoA = findViewById(R.id.radio_two_a);
        RadioButton RadioButtonTwoB = findViewById(R.id.radio_two_b);
        RadioButton RadioButtonTwoC = findViewById(R.id.radio_two_c);
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

        EditText questionThreeText = (EditText) findViewById(R.id.input_first_random_text_question);
        String questionThree = questionThreeText.getText().toString().toUpperCase();
        EditText questionFourText = (EditText) findViewById(R.id.input_second_random_text_question);
        String questionFour = questionFourText.getText().toString().toUpperCase();

        String questionFive = "";
        CheckBox questionFiveA = (CheckBox) findViewById(R.id.checkbox_one_a);
        boolean questionFiveAChecked = questionFiveA.isChecked();
        if (questionFiveAChecked) {
            questionFive += 'a';
        }
        CheckBox questionFiveB = (CheckBox) findViewById(R.id.checkbox_one_b);
        boolean questionFiveBChecked = questionFiveB.isChecked();
        if (questionFiveBChecked) {
            questionFive += 'b';
        }
        CheckBox questionFiveC = (CheckBox) findViewById(R.id.checkbox_one_c);
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


    public void verifyResults(View view ) {

       /** String answera = textQuestionsPool[secondRandomTextQuestionNumber+1];
        int a = firstRandomTextQuestionNumber;
        int b = secondRandomTextQuestionNumber;
        String[] strquestio = textQuestionsPool;*/

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
            if (questionOne.equals(radioQuestionsPool[firstRandomRadioQuestionNumber+4])) {

                playerScore += 1;
            }
            String questionTwo = answers.get(1).toString();
            if (questionTwo.equals(radioQuestionsPool[secondRandomRadioQuestionNumber+4])) {
                playerScore += 1;
            }
            String questionThree = answers.get(2).toString();
            if (questionThree.equals(textQuestionsPool[firstRandomTextQuestionNumber+1])){
                playerScore += 1;
            }
            String questionFour = answers.get(3).toString();
            if (questionFour.equals(textQuestionsPool[secondRandomTextQuestionNumber+1])) {
                playerScore += 1;
            }
            String questionFive = answers.get(4).toString();
            if (questionFive.equals(checkboxQuestionsPool[firstRandomCheckboxQuestionNumber+4])) {
                playerScore += 1;
            }

            String pointNumber = String.valueOf(playerScore);
            String result = getString(R.string.congrats);
            String resultPoints = getString(R.string.congratspoints);
            result += "\n" + resultPoints + pointNumber;

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