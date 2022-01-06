package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static DatabaseHelper dbHelper;
    private int last_id = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(getApplicationContext());
        getAllItems();
    }

    public void getAllItems() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // dbHelper.onUpgrade(db, 1, 2);
        ListView listView = (ListView) findViewById(R.id.itemsList);

        String[] fromColumns = {
                DatabaseContract.TodoItem.COL_NAME_TEXT
        };
        int[] toViews = { R.id.todoItem };

        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseContract.TodoItem.TABLE_NAME, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.todo_item, cursor, fromColumns, toViews, 0);
        listView.setAdapter(adapter);
    }

    public void addItem(View v) {
        EditText editText = findViewById(R.id.newItemText);
        String newItem = editText.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TodoItem.COL_NAME_ID, last_id);
        values.put(DatabaseContract.TodoItem.COL_NAME_TEXT, newItem);

        try {
            long newRowId = db.insert(DatabaseContract.TodoItem.TABLE_NAME, null, values);
        } catch(Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(), "An error occurred while creating", Toast.LENGTH_LONG);
            toast.show();
            e.printStackTrace();
        }

        last_id++;
        editText.setText("");

        getAllItems();
    }

    public void deleteItem(View v) {
        ViewGroup parent = (ViewGroup) v.getParent();
        TextView textView = (TextView) parent.getChildAt(0);
        String toDelete = textView.getText().toString();

        String selection = DatabaseContract.TodoItem.COL_NAME_TEXT+ " LIKE ?";
        String[] selectionArgs = { toDelete };

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int deletedRows = db.delete(DatabaseContract.TodoItem.TABLE_NAME, selection, selectionArgs);
        getAllItems();
    }
}
