package com.example.calendarwidgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DateDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_display);
        Intent intent = getIntent();
        TextView dateValue = findViewById(R.id.dateValue);
        dateValue.setText(intent.getStringExtra(MainActivity.EXTRA_DATE));
    }
}