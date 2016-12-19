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
    public static class QuestionTable{
        public static final String NAME = "question";

        public static final class Cols {
            public static final String DATE = "date";
            public static final String QUESTIONNUM = "questionnum";
            public static final String SUBQUESTIONNUM = "subquestionnum";
            public static final String TEXT = "text";
        }
    }
}
