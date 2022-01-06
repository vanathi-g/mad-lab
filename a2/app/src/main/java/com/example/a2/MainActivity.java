package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateText(View v){
        EditText expression = (EditText)findViewById(R.id.expression);
        String newExpression = expression.getText().toString() + v.getTag().toString();
        if(v.getTag().toString().equals("clearAll")) {
            newExpression = "";
        }

        expression.setText(newExpression, TextView.BufferType.EDITABLE);
    }

    public void evaluateExpression(View v){
        EditText expression = (EditText)findViewById(R.id.expression);
        Expression expr = new Expression(expression.getText().toString());
        try{
            BigDecimal result = expr.eval();
            expression.setText(result.toString(), TextView.BufferType.EDITABLE);
        } catch(Exception e) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Invalid Expression", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
