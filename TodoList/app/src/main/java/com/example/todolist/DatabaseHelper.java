package com.example.todolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TodoItems.db";
    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + DatabaseContract.TodoItem.TABLE_NAME + "(" +
            DatabaseContract.TodoItem.COL_NAME_ID + " INTEGER PRIMARY KEY, " +
            DatabaseContract.TodoItem.COL_NAME_TEXT + " TEXT)";
    private static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS " + DatabaseContract.TodoItem.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
