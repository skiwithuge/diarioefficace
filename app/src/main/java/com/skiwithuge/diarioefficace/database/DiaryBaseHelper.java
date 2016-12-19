package com.skiwithuge.diarioefficace.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.skiwithuge.diarioefficace.database.DiaryDbSchema.DayTable;
import com.skiwithuge.diarioefficace.database.DiaryDbSchema.QuestionTable;
/**
 * Created by skiwithuge on 11/20/16.
 */

public class DiaryBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DiaryBaseHelper";
    private static final int VERSION = 4;
    private static final String DATABASE_NAME = "diaryBase.db";

    public DiaryBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DayTable.NAME + "(" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DayTable.Cols.DATE + " TEXT UNIQUE , " +
                DayTable.Cols.PHASE +
                ")"
        );
        db.execSQL("CREATE TABLE " + QuestionTable.NAME + "(" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.Cols.DATE + " TEXT, " +
                QuestionTable.Cols.QUESTIONNUM + " INTEGER , " +
                QuestionTable.Cols.SUBQUESTIONNUM + " INTEGER , " +
                QuestionTable.Cols.TEXT + " TEXT " +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + DayTable.NAME);
//        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.NAME);
//        onCreate(db);
    }
}
