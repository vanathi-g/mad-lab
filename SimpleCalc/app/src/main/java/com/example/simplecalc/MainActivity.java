package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalcBtnClick(View v) {
        TextView exprView = findViewById(R.id.exprView);
        String selected = ((Button) v).getText().toString();
        if(selected.equals("=")) {
            DoubleEvaluator evaluator = new DoubleEvaluator();
            String result = evaluator.evaluate(exprView.getText().toString()).toString();
            exprView.setText(result);
        } else if (selected.equals("C")) {
            String current = exprView.getText().toString();
            if(current.length() > 0)
                exprView.setText(String.format("%s", current.substring(0, current.length() - 1)));
        } else {
            exprView.setText(String.format("%s%s", exprView.getText().toString(), selected));
        }
    }
}