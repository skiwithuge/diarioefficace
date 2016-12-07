package com.skiwithuge.diarioefficace.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.skiwithuge.diarioefficace.database.DayCursorWrapper;
import com.skiwithuge.diarioefficace.database.DiaryBaseHelper;
import com.skiwithuge.diarioefficace.database.DiaryDbSchema.DayTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by skiwithuge on 12/3/16.
 */

public class DayList {
    private static DayList sDayList;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DayList get(Context context){
        if(sDayList == null)
            sDayList = new DayList(context);
        return sDayList;
    }

    private DayList(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new DiaryBaseHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Day day){
        ContentValues values = new ContentValues();
        values.put(DayTable.Cols.UUID, day.getId().toString());
        values.put(DayTable.Cols.DAY, day.getDate().toString());
        values.put(DayTable.Cols.Q1, day.getQ1());
        values.put(DayTable.Cols.Q2, day.getQ2());
        values.put(DayTable.Cols.Q3, day.getQ3());
        values.put(DayTable.Cols.Q4, day.getQ4());
        values.put(DayTable.Cols.Q5, day.getQ5());

        return values;
    }

    public void addDay(Day d){
        ContentValues values = getContentValues(d);

        mDatabase.insert(DayTable.NAME, null, values);
    }

    public void updateDay(Day d){
        String uuidString = d.getId().toString();
        ContentValues values = getContentValues(d);

        mDatabase.update(DayTable.NAME, values,
                DayTable.Cols.UUID + " = ?",
                new String[] { uuidString});
    }

    private DayCursorWrapper queryDays(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                DayTable.NAME,
                null, //Columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );

        return new DayCursorWrapper(cursor);
    }

    public List<Day> getDays() {
        List<Day> days = new ArrayList<>();

        DayCursorWrapper cursor = queryDays(null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            days.add(cursor.getDay());
            cursor.moveToNext();
        }
        cursor.close();

        return days;
    }

    public Day getDay(UUID id){
        DayCursorWrapper cursor = queryDays(
                DayTable.Cols.UUID + " = ?",
                new String[] {id.toString()}
        );

        try {
            if (cursor.getCount() == 0)
                return null;

            cursor.moveToFirst();
            return cursor.getDay();
        } finally {
            cursor.close();
        }
    }
}
