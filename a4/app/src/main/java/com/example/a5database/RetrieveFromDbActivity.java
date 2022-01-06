package com.example.a5database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RetrieveFromDbActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_from_db);
    }

    public void onSearchBtnClick(View view) {
        EditText editText;
        TextView textView;

        editText = (EditText) findViewById(R.id.codeRetrieveInput);
        String code = editText.getText().toString();

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
        }

        while(cursor.moveToNext()) {
            textView = findViewById(R.id.codeRetrieveValue);
            textView.setText(code);

            String ename = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_ENAME));
            textView = findViewById(R.id.nameRetrieveValue);
            textView.setText(ename);

            String gender = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_GENDER));
            textView = findViewById(R.id.genderRetrieveValue);
            textView.setText(gender);

            String dept = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_DEPT));
            textView = findViewById(R.id.deptRetrieveValue);
            textView.setText(dept);

            int salary = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.EmployeeEntry.COLUMN_NAME_SALARY));
            textView = findViewById(R.id.salaryRetrieveValue);
            textView.setText(String.valueOf(salary));
        }
    }
}
