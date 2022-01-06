package com.example.a5database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

public class DatabaseHelper extends SQLiteOpenHelper implements Serializable {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Employee.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseContract.EmployeeEntry.TABLE_NAME + " (" +
                    DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE + " INTEGER PRIMARY KEY," +
                    DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME + " TEXT," +
                    DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER + " TEXT," +
                    DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY + " INTEGER," +
                    DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseContract.EmployeeEntry.TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
