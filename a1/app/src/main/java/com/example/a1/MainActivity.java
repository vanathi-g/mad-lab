package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String NAME = "com.example.a1.NAME";
    public static final String ADDRESS = "com.example.a1.ADDRESS";
    public static final String PHONE = "com.example.a1.PHONE";
    public static final String AGE = "com.example.a1.AGE";
    public static final String DOB = "com.example.a1.DOB";
    public static final String TIME = "com.example.a1.TIME";
    public static final String GENDER = "com.example.a1.GENDER";
    public static final String MARITAL = "com.example.a1.MARITAL";
    public static final String ADDICTION = "com.example.a1.ADDICTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.marital_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.editTextName);
        intent.putExtra(NAME, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextAddress);
        intent.putExtra(ADDRESS, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextAge);
        intent.putExtra(AGE, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextPhone);
        intent.putExtra(PHONE, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextDate);
        intent.putExtra(DOB, editText.getText().toString());

        editText = (EditText) findViewById(R.id.editTextTime);
        intent.putExtra(TIME, editText.getText().toString());

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        int selected = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selected);
        intent.putExtra(GENDER, radioButton.getText().toString());

        String smokes = "";
        String drinks = "";
        CheckBox smoking = (CheckBox) findViewById(R.id.smokingCheckBox);
        CheckBox drinking = (CheckBox) findViewById(R.id.alcoholCheckBox);
        if(smoking.isChecked()) {
            smokes = smoking.getText().toString();
        }
        if(drinking.isChecked()) {
            drinks = drinking.getText().toString();
        }
        intent.putExtra(ADDICTION, smokes + ", " + drinks);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        intent.putExtra(MARITAL, spinner.getSelectedItem().toString());

        startActivity(intent);
    }
}
