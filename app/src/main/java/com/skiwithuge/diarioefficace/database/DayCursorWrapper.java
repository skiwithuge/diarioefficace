package com.skiwithuge.diarioefficace.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.skiwithuge.diarioefficace.model.Day;

import com.skiwithuge.diarioefficace.database.DiaryDbSchema.DayTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class DayCursorWrapper extends CursorWrapper {

    public DayCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Day getDay(){
        String uuidString = getString(getColumnIndex(DayTable.Cols.UUID));
        long date = getLong(getColumnIndex(DayTable.Cols.DAY));
        String q1 = getString(getColumnIndex(DayTable.Cols.Q1));
        String q2 = getString(getColumnIndex(DayTable.Cols.Q2));
        String q3 = getString(getColumnIndex(DayTable.Cols.Q3));
        String q4 = getString(getColumnIndex(DayTable.Cols.Q4));
        String q5 = getString(getColumnIndex(DayTable.Cols.Q5));

        Day day = new Day(UUID.fromString(uuidString));
        day.setDate(new Date(date));
        day.setQ1(q1);
        day.setQ2(q2);
        day.setQ3(q3);
        day.setQ4(q4);
        day.setQ5(q5);

        return day;
    }
}
