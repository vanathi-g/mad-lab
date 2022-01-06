package com.example.a5database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteFromDbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_from_db);
    }

    public void onDeleteEmpBtnClick(View view){
        EditText editText;

        editText = (EditText) findViewById(R.id.codeDeleteInput);
        String code = editText.getText().toString();

        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        String selection = DatabaseContract.EmployeeEntry.COLUMN_NAME_ECODE+ " LIKE ?";
        String[] selectionArgs = { code };
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int deletedRows = db.delete(DatabaseContract.EmployeeEntry.TABLE_NAME, selection, selectionArgs);

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_LONG;

        if(deletedRows > 0){
            text = "Employee record deleted successfully";
        } else {
            text = "Employee not found";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
