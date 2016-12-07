package com.skiwithuge.diarioefficace.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class Day {
    private UUID mID;
    private Date mDate;
    private String mQ1;
    private String mQ2;
    private String mQ3;
    private String mQ4;
    private String mQ5;

    public Day(UUID id) {
        mID = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mID;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date day) {
        mDate = day;
    }

    public String getQ1() {
        return mQ1;
    }

    public void setQ1(String q1) {
        mQ1 = q1;
    }

    public String getQ2() {
        return mQ2;
    }

    public void setQ2(String q2) {
        mQ2 = q2;
    }

    public String getQ3() {
        return mQ3;
    }

    public void setQ3(String q3) {
        mQ3 = q3;
    }

    public String getQ4() {
        return mQ4;
    }

    public void setQ4(String q4) {
        mQ4 = q4;
    }

    public String getQ5() {
        return mQ5;
    }

    public void setQ5(String q5) {
        mQ5 = q5;
    }
}
