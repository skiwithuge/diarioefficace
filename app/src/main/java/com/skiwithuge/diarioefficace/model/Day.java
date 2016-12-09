package com.skiwithuge.diarioefficace.model;

import com.skiwithuge.diarioefficace.Constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class Day {
    private Date mDate;
    private int phase; //0 incomplete, 1 half, 2 completed

    public Day(){
        try {
            mDate = Constants.sdf.parse(Constants.sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        try {
            mDate = Constants.sdf.parse(Constants.sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}
