package com.skiwithuge.diarioefficace.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 12/9/16.
 */

public class Question {
    private Date mDate;
    private int mQuestionNumber;
    private int mSubQuestionNumber;
    private String mAnswer;

    public Question(){
        mDate = new Date();
    }
    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public int getQuestionNumber() {
        return mQuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        mQuestionNumber = questionNumber;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public int getSubQuestionNumber() {
        return mSubQuestionNumber;
    }

    public void setSubQuestionNumber(int subQuestionNumber) {
        mSubQuestionNumber = subQuestionNumber;
    }
}
