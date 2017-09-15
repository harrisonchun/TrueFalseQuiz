package com.example.harrison.truefalsequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button trueButton,falseButton,nextButton;
    private TextView questionText;

    private ArrayList questionBank;

    private boolean userAnswer;

    private int bankPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        initQuestionBank();
        bankPos=0;
        questionText.setText(R.string.question_1);
    }

    private void initQuestionBank() {
        questionBank= new ArrayList();
        questionBank.add(new Question(getString(R.string.question_0),true));
        questionBank.add(new Question(getString(R.string.question_1),false));
        questionBank.add(new Question(getString(R.string.question_2),false));
        questionBank.add(new Question(getString(R.string.question_3),true));
        questionBank.add(new Question(getString(R.string.question_4),true));

    }

    private void setListeners() {
        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void wireWidgets() {
        trueButton=(Button) findViewById(R.id.button_true);
        falseButton=(Button) findViewById(R.id.button_false);
        nextButton=(Button) findViewById(R.id.button_next);
        questionText=(TextView) findViewById(R.id.question_text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_true:
                userAnswer=true;
                break;
            case R.id.button_false:
                userAnswer=false;
                break;
            case R.id.button_next:
                if (userAnswer!=null)
                questionBank.get(0).checkAnswer(userAnswer);
                break;
        }
    }

    private void nextQuestion() {
        if (bankPos<questionBank.size()){bankPos++;}
        else {bankPos=0;};
    }
}
