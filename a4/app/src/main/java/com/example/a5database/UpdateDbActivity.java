package com.example.a5database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDbActivity extends AppCompatActivity {
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_db);
    }

    public void onSearchUpdateBtnClick(View view) {
        EditText editText;
        RadioButton radioButton;

        editText = (EditText) findViewById(R.id.codeSearchUpdateInput);
        code = editText.getText().toString();

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE,
                DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME,
                DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER,
                DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY,
                DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT
        };

        String selection = DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE + " = ?";
        String[] selectionArgs = { code };

        Cursor cursor = db.query(DatabaseContract.EmployeeEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        if(cursor.getCount() == 0){
            Context context = getApplicationContext();
            CharSequence text = "Employee not found";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            while(cursor.moveToNext()) {
                String ename = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME));
                editText = (EditText) findViewById(R.id.nameUpdateInput);
                editText.setText(ename);

                String gender = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER));
                switch(gender){
                    case "Male":
                        radioButton = (RadioButton) findViewById(R.id.genderUpdateMale);
                        radioButton.setChecked(true);
                        break;
                    case "Female":
                        radioButton = (RadioButton) findViewById(R.id.genderUpdateFemale);
                        radioButton.setChecked(true);
                        break;
                    case "Other":
                        radioButton = (RadioButton) findViewById(R.id.genderUpdateOther);
                        radioButton.setChecked(true);
                        break;
                }

                String dept = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT));
                editText = (EditText) findViewById(R.id.deptUpdateInput);
                editText.setText(dept);

                int salary = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY));
                editText = (EditText) findViewById(R.id.salaryUpdateInput);
                editText.setText(String.valueOf(salary));
            }
        }
    }

    public void onUpdateSubmitBtnClick(View view) {
        EditText editText;

        editText = (EditText)findViewById(R.id.nameUpdateInput);
        String name = editText.getText().toString();

        editText = (EditText)findViewById(R.id.deptUpdateInput);
        String dept = editText.getText().toString();

        editText = (EditText)findViewById(R.id.salaryUpdateInput);
        int salary = Integer.parseInt(editText.getText().toString());

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.genderUpdateInput);
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = radioButton.getText().toString();

        // Updating the database
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME, name);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER, gender);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT, dept);
        values.put(DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY, salary);

        String selection = DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE + " LIKE ?";
        String[] selectionArgs = { code };

        int count = db.update(
                DatabaseContract.EmployeeEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_LONG;

        if(count == 0){
            text = "Error occurred, update failed";
        } else {
            text = "Employee record updated successfully";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}