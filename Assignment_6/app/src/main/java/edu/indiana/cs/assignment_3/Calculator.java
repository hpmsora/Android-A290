package edu.indiana.cs.assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends AppCompatActivity {

    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting Info
        SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
        String CurrUser = myPref.getString("Current", "N/A");
        String Pinfo = myPref.getString(CurrUser, "N/A");

        String[] PinfoSpliting = Pinfo.split("%%%%");

        //Fill the personal Info
        TextView nameView = (TextView) findViewById(R.id.nameTextView);
        TextView emailView = (TextView) findViewById(R.id.emailTextView);

        //Personal Info setting the text
        nameView.setText(PinfoSpliting[1] + ", " + PinfoSpliting[0]);
        emailView.setText(PinfoSpliting[2]);

        TextView textCal = (TextView) findViewById(R.id.cal_Text);
        textCal.setText(text);

        //Set the Background color
        SharedPreferences myColor = getSharedPreferences("Color", MODE_PRIVATE);
        String coloring = myColor.getString("color", "N/A");

        GridLayout x = (GridLayout) findViewById(R.id.cal_Layout);
        x.setBackgroundColor(Color.parseColor(coloring));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //Checking Functions
    //isNumeric From Google source
    // http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    //Printing function
    // print on the cal_Text
    public void printing(View v) {
        TextView textCal = (TextView) findViewById(R.id.cal_Text);
        textCal.setText(text);
    }

    //Button Clicking
    public void btn_1(View v) {
        text += "1";
        printing(v);
    }
    public void btn_2(View v) {
        text += "2";
        printing(v);
    }
    public void btn_3(View v) {
        text += "3";
        printing(v);
    }
    public void btn_4(View v) {
        text += "4";
        printing(v);
    }
    public void btn_5(View v) {
        text += "5";
        printing(v);
    }
    public void btn_6(View v) {
        text += "6";
        printing(v);
    }
    public void btn_7(View v) {
        text += "7";
        printing(v);
    }
    public void btn_8(View v) {
        text += "8";
        printing(v);
    }
    public void btn_9(View v) {
        text += "9";
        printing(v);
    }
    public void btn_0(View v) {
        text += "0";
        printing(v);
    }
    public void btn_plus(View v) {
        text += " + ";
        printing(v);
    }
    public void btn_minus(View v) {
        text += " - ";
        printing(v);
    }
    public void btn_div(View v) {
        text += " / ";
        printing(v);
    }
    public void btn_mul(View v) {
        text += " * ";
        printing(v);
    }
    public void btn_power(View v) {
        text += " ^2";
        printing(v);
    }
    public void btn_root(View v) {
        text += " ^1/2";
        printing(v);
    }

    //Equal button : Calculate and determination
    public void btn_equal(View v) {

        String result = calculating(text);

        text = text + " = " + result;

        printing(v);

    }

    //Calculate function
    public String calculating(String str) {
        String[] splitStr =  str.split(" ");

        String total = "";

        List<String> stringList = new ArrayList<String>(Arrays.asList(splitStr));
        List<String> newStringLsit = new ArrayList<String>();

        //Power Calculating
        for(int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equals("^2")) {
                String subx = stringList.get(i - 1);
                //Numerical validation
                if(!(isNumeric(subx))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }
                double x = Double.parseDouble(subx);
                x = Math.pow(x, 2);
                String xStr = Double.toString(x);
                stringList.set(i, xStr);
                stringList.set(i - 1, "none");
            }
            else if(stringList.get(i).equals("^1/2")) {
                String subx = stringList.get(i - 1);
                //Numerical validation
                if(!(isNumeric(subx))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }
                double x = Double.parseDouble(subx);
                x = Math.sqrt(x);
                String xStr = Double.toString(x);
                stringList.set(i, xStr);
                stringList.set(i - 1, "none");
            }
        }

        //Reseting
        for(String i : stringList) {
            if(!(i.equals("none"))) {
                newStringLsit.add(i);
            }
        }

        str = "";
        for(int i = 0; i < newStringLsit.size(); i++) {
            if(i == 0) {
                str = newStringLsit.get(i);
            }
            else
                str = str + " " + newStringLsit.get(i);
        }

        //Re-saving the list
        splitStr = str.split(" ");
        stringList = new ArrayList<String>(Arrays.asList(splitStr));
        newStringLsit = new ArrayList<String>();

        //Mul and Div Calculating
        for(int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equals("*")) {
                String subx1 = stringList.get(i - 1);
                String subx2 = stringList.get(i + 1);
                //Numerical validation
                if(!(isNumeric(subx1) && isNumeric(subx2))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }

                float x1 = Float.parseFloat(subx1);
                float x2 = Float.parseFloat(subx2);
                stringList.set(i + 1, Float.toString(x1 * x2));
                stringList.set(i - 1, "none");
                stringList.set(i, "none");
            }
            else if(stringList.get(i).equals("/")) {
                String subx1 = stringList.get(i - 1);
                String subx2 = stringList.get(i + 1);
                //Numerical validation
                if(!(isNumeric(subx1) && isNumeric(subx2))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }

                float x1 = Float.parseFloat(subx1);
                float x2 = Float.parseFloat(subx2);
                //Special case - Divided by zero
                if(x2 == 0) {
                    Toast.makeText(this, "Cannot Divided by Zero", Toast.LENGTH_LONG).show();
                    return "";
                }
                stringList.set(i + 1, Float.toString(x1 / x2));
                stringList.set(i - 1, "none");
                stringList.set(i, "none");

            }
        }

        //Reseting
        for(String i : stringList) {
            if(!(i.equals("none"))) {
                newStringLsit.add(i);
            }
        }

        str = "";
        for(int i = 0; i < newStringLsit.size(); i++) {
            if(i == 0) {
                str = newStringLsit.get(i);
            }
            else
                str = str + " " + newStringLsit.get(i);
        }

        //Re-saving the list
        splitStr = str.split(" ");
        stringList = new ArrayList<String>(Arrays.asList(splitStr));
        newStringLsit = new ArrayList<String>();

        //Mul and Div Calculating
        for(int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equals("+")) {
                String subx1 = stringList.get(i - 1);
                String subx2 = stringList.get(i + 1);

                if(!(isNumeric(subx1) && isNumeric(subx2))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }

                float x1 = Float.parseFloat(subx1);
                float x2 = Float.parseFloat(subx2);
                stringList.set(i + 1, Float.toString(x1 + x2));
                stringList.set(i - 1, "none");
                stringList.set(i, "none");
            }
            else if(stringList.get(i).equals("-")) {
                String subx1 = stringList.get(i - 1);
                String subx2 = stringList.get(i + 1);

                if(!(isNumeric(subx1) && isNumeric(subx2))) {
                    Toast.makeText(this,"Numerical Error", Toast.LENGTH_LONG).show();
                    return "";
                }

                float x1 = Float.parseFloat(subx1);
                float x2 = Float.parseFloat(subx2);
                stringList.set(i + 1, Float.toString(x1 - x2));
                stringList.set(i - 1, "none");
                stringList.set(i, "none");

            }
        }

        //Reseting
        for(String i : stringList) {
            if(!(i.equals("none"))) {
                newStringLsit.add(i);
            }
        }

        str = "";
        for(int i = 0; i < newStringLsit.size(); i++) {
            if(i == 0) {
                str = newStringLsit.get(i);
            }
            else
                str = str + " " + newStringLsit.get(i);
        }
        total = str;
        return total;
    }

    //delete on prase
    public void btn_delete(View v) {
        String[] curStr = text.split(" ");
        String[] newStr = new String[curStr.length- 1];
        for(int i = 0; i < curStr.length - 1; i++)
            newStr[i] = curStr[i];
        text = "";
        for(int i = 0; i < newStr.length; i++) {
            if(i == 0) {
                text = newStr[0];
            }
            else
                text = text + " " + newStr[i];
        }
        printing(v);
    }

    //clear all
    public void btn_clear(View v) {
        text = "";
        printing(v);
    }

    //go back
    public void btn_logout(View view) {
        Intent x = new Intent(this, MainActivity.class);
        startActivity(x);
    }

    public void CalBackingButton(View view) {
        Intent x = new Intent(this, optionActivity.class);
        startActivity(x);
    }
}
