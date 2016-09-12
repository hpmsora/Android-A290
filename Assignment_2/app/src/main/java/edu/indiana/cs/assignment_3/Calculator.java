package edu.indiana.cs.assignment_3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void btn_1(View v) {
        text += "1";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_2(View v) {
        text += "2";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_3(View v) {
        text += "3";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_4(View v) {
        text += "4";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_5(View v) {
        text += "5";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_6(View v) {
        text += "6";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_7(View v) {
        text += "7";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_8(View v) {
        text += "8";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_9(View v) {
        text += "9";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_0(View v) {
        text += "0";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_plus(View v) {
        text += "+";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_minus(View v) {
        text += "-";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_div(View v) {
        text += "/";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_mul(View v) {
        text += "*";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_power(View v) {
        text += "^2";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }
    public void btn_root(View v) {
        text += "^1/2";
        ((TextView)findViewById(R.id.TEXT)).setText(text);
    }

}
