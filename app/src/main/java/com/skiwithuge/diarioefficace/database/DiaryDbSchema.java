package com.skiwithuge.diarioefficace.database;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class DiaryDbSchema {
    public static class DayTable{
        public static final String NAME = "day";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String DAY = "day";
            public static final String Q1 = "q1";
            public static final String Q2 = "q2";
            public static final String Q3 = "q3";
            public static final String Q4 = "q4";
            public static final String Q5 = "q5";
        }
    }
}
