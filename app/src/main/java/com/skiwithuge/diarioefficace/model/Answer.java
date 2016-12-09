package com.skiwithuge.diarioefficace.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 12/9/16.
 */

public class Answer {
    private UUID mID;
    private Date mDate;
    private int mQuestionNumber;
    private String[] mAnswer;

    public Answer(UUID id){
        mID = id;
        mDate = new Date();
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
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

    public String[] getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String[] answer) {
        mAnswer = answer;
    }
}
