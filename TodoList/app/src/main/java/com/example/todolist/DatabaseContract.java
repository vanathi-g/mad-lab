package com.example.todolist;

import android.provider.BaseColumns;

public class DatabaseContract {
    private DatabaseContract(){};
    public static class TodoItem implements BaseColumns {
        public static final String TABLE_NAME = "items";
        public static final String COL_NAME_ID = "_id";
        public static final String COL_NAME_TEXT = "text";
    }
}
