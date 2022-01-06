package com.example.a7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onReadBtnClick(View v) {
        EditText fileName = findViewById(R.id.fileName);
        EditText fileContent = findViewById(R.id.fileContent);
        String line, text="";

        File file = new File(getFilesDir(), fileName.getEditableText().toString());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null) {
                text += line;
            }
            fileContent.setText(text);
            Toast.makeText(MainActivity.this, "File Read!", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            Toast.makeText(MainActivity.this, "File does not exist.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "An error occurred while reading the file.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onWriteBtnClick(View v) {
        EditText fileName = findViewById(R.id.fileName);
        EditText fileContent = findViewById(R.id.fileContent);

        File file = new File(getFilesDir(), fileName.getEditableText().toString());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(fileContent.getEditableText().toString().getBytes());
            fileOutputStream.close();
            fileContent.setText("");
            Toast.makeText(MainActivity.this, "File Written!", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(MainActivity.this, "An error occurred while writing to the file.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}