package com.skiwithuge.diarioefficace.database;

/**
 * Created by skiwithuge on 11/20/16.
 */

public class DiaryDbSchema {
    public static class DayTable{
        public static final String NAME = "day";

        public static final class Cols {
            public static final String DATE = "date";
            public static final String PHASE = "phase";
        }
    }
}
