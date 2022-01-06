package com.example.a5database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCreateBtnClick(View view){
        dbHelper = new DatabaseHelper(getApplicationContext());
    }

    public void onInsertBtnClick(View view) {
        Intent intent = new Intent(this, InsertIntoDbActivity.class);
        startActivity(intent);
    }

    public void onRetrieveBtnClick(View view) {
        Intent intent = new Intent(this, RetrieveFromDbActivity.class);
        startActivity(intent);
    }

    public void onDeleteBtnClick(View view) {
        Intent intent = new Intent(this, DeleteFromDbActivity.class);
        startActivity(intent);
    }

    public void onUpdateBtnClick(View view) {
        Intent intent = new Intent(this, UpdateDbActivity.class);
        startActivity(intent);
    }
}
