package com.example.calendarwidgetapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_DATE = "com.example.calendarwidgetapp.DATE";

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setVisibility(View.INVISIBLE);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                TextView dateView = findViewById(R.id.dateView);
                dateView.setText(String.format("%s/%s/%s", day, month+1, year));
            }
        });
    }

    public void onDateBtnClick(View v) {
        calendarView.setVisibility(View.VISIBLE);
    }

    public void onSubmitBtnClick(View v) {
        TextView dateView = findViewById(R.id.dateView);
        Intent intent = new Intent(this, DateDisplayActivity.class);
        intent.putExtra(EXTRA_DATE, dateView.getText().toString());
        startActivity(intent);
    }
}