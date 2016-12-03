package com.skiwithuge.diarioefficace.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.skiwithuge.diarioefficace.database.DiaryDbSchema.DayTable;
/**
 * Created by skiwithuge on 11/20/16.
 */

public class DiaryBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DiaryBaseHelper";
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "diaryBase.db";

    public DiaryBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DayTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                DayTable.Cols.UUID + ", " +
                DayTable.Cols.DAY + ", " +
                DayTable.Cols.Q1 + ", " +
                DayTable.Cols.Q2 + ", " +
                DayTable.Cols.Q3 + ", " +
                DayTable.Cols.Q4 + ", " +
                DayTable.Cols.Q5 +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
