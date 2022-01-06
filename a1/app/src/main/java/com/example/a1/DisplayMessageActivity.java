package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.nameResponse);
        textView.setText(intent.getStringExtra(MainActivity.NAME));

        textView = findViewById(R.id.addressResponse);
        textView.setText(intent.getStringExtra(MainActivity.ADDRESS));

        textView = findViewById(R.id.phoneResponse);
        textView.setText(intent.getStringExtra(MainActivity.PHONE));

        textView = findViewById(R.id.ageResponse);
        textView.setText(intent.getStringExtra(MainActivity.AGE));

        textView = findViewById(R.id.dobResponse);
        textView.setText(intent.getStringExtra(MainActivity.DOB));

        textView = findViewById(R.id.timeResponse);
        textView.setText(intent.getStringExtra(MainActivity.TIME));

        textView = findViewById(R.id.genderResponse);
        textView.setText(intent.getStringExtra(MainActivity.GENDER));

        textView = findViewById(R.id.addictionResponse);
        textView.setText(intent.getStringExtra(MainActivity.ADDICTION));

        textView = findViewById(R.id.maritalResponse);
        textView.setText(intent.getStringExtra(MainActivity.MARITAL));
    }
}
