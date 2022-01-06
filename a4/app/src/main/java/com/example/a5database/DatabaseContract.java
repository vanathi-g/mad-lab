package com.example.a5database;

import android.provider.BaseColumns;

public class DatabaseContract {
    private DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static class EmployeeEntry implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_NAME_ENAME = "name";
        public static final String COLUMN_NAME_GENDER = "gender";
        public static final String COLUMN_NAME_ECODE = "code";
        public static final String COLUMN_NAME_DEPT = "dept";
        public static final String COLUMN_NAME_SALARY= "salary";
    }
}
