package com.example.harrison.truefalsequiz;

/**
 * Created by harrison on 9/15/2017.
 */

public class Question {
    private String question;
    private boolean answer;

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }
    public boolean checkAnswer;

    public String getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public boolean checkAnswer(boolean userAnswer){
        return answer==userAnswer;
    }

}

