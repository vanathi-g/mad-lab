package com.example.a5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSleepBtnClick(View v) {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("IN PROGRESS");
        progressDialog.setMessage("Started sleeping...");
        progressDialog.show();
        EditText editText = findViewById(R.id.inputTime);
        int count = Integer.parseInt(editText.getEditableText().toString());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, count*1000);
    }

    public void onStartBtnClick(View v) {
        progressBar = findViewById(R.id.progressBar);
        EditText editText = findViewById(R.id.inputTime);
        int count = Integer.parseInt(editText.getEditableText().toString());
        int inc = (int)(100/count);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i;
                for(i=0; i<=100; i+=inc){
                    progressBar.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                progressBar.setProgress(100);
                progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            }
        }).start();
    }
}