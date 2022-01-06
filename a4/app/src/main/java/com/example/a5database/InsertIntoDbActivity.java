package com.example.a5database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsertIntoDbActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_into_db);
    }

    public void onInputSubmitBtnClick(View view){
        EditText editText;

        editText = (EditText)findViewById(R.id.codeInsertInput);
        int code = Integer.parseInt(editText.getText().toString());

        editText = (EditText)findViewById(R.id.nameInsertInput);
        String name = editText.getText().toString();

        editText = (EditText)findViewById(R.id.deptInsertInput);
        String dept = editText.getText().toString();

        editText = (EditText)findViewById(R.id.salaryInsertInput);
        int salary = Integer.parseInt(editText.getText().toString());

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.genderInsertinput);
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = radioButton.getText().toString();

        // Inserting into database
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE, code);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME, name);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER, gender);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT, dept);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY, salary);

        long newRowId = db.insert(DatabaseContract.EmployeeEntry.TABLE_NAME, null, values);

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_LONG;

        if(newRowId == -1){
            text = "Error occurred, insertion failed";
        } else {
            text = "Employee record inserted successfully";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
