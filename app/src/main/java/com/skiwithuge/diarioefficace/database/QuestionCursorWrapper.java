package com.skiwithuge.diarioefficace.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.skiwithuge.diarioefficace.Constants;
import com.skiwithuge.diarioefficace.model.Question;
import com.skiwithuge.diarioefficace.database.DiaryDbSchema.QuestionTable;

import java.text.ParseException;

/**
 * Created by skiwithuge on 12/19/16.
 */

public class QuestionCursorWrapper extends CursorWrapper {
    public QuestionCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Question getQuestion(){
        String date = getString(getColumnIndex(QuestionTable.Cols.DATE));
        int questionNumber = getInt(getColumnIndex(QuestionTable.Cols.QUESTIONNUM));
        int subQuestionNumber = getInt(getColumnIndex(QuestionTable.Cols.SUBQUESTIONNUM));
        String text = getString(getColumnIndex(QuestionTable.Cols.TEXT));

        Question q = new Question();
        try {
            q.setDate(Constants.sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        q.setQuestionNumber(questionNumber);
        q.setSubQuestionNumber(subQuestionNumber);
        q.setAnswer(text);

        return q;
    }
}
