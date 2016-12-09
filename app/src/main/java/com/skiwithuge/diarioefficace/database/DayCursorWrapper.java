package com.skiwithuge.diarioefficace.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.skiwithuge.diarioefficace.Constants;
import com.skiwithuge.diarioefficace.MyApplication;
import com.skiwithuge.diarioefficace.database.DiaryDbSchema.DayTable;
import com.skiwithuge.diarioefficace.model.Day;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class DayCursorWrapper extends CursorWrapper {

    public DayCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Day getDay(){
        String date = getString(getColumnIndex(DayTable.Cols.DATE));
        int phase = getInt(getColumnIndex(DayTable.Cols.PHASE));

        Day day = new Day();

        try {
            day.setDate(Constants.sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        day.setPhase(phase);

        return day;
    }
}
