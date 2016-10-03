package edu.indiana.cs.assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;

public class signUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Setup the background color
        SharedPreferences myColor = getSharedPreferences("Color", MODE_PRIVATE);
        String coloring = myColor.getString("color", "N/A");

        RelativeLayout SUlayout = (RelativeLayout) findViewById(R.id.signUpLayout);
        SUlayout.setBackgroundColor(Color.parseColor(coloring));
    }

    public void btn_SUSginUp(View view) {
        EditText firstNameET = (EditText) findViewById(R.id.SUFirstNameFeild);
        String firstName = firstNameET.getText().toString();
        EditText lastNameET = (EditText) findViewById(R.id.SULastNameFeild);
        String lastName = lastNameET.getText().toString();
        EditText emailET = (EditText) findViewById(R.id.SUEmailFeild);
        String eMail = emailET.getText().toString();
        EditText pwET = (EditText) findViewById(R.id.SUPWFeild);
        String pW = pwET.getText().toString();

        if(checkFilled(view) && emailValidCheck(eMail)) {

            SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = myPref.edit();

            Map<String, ?> allEntries = myPref.getAll();
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                String currKey = entry.getKey();
                if(eMail.equals(currKey)) {
                    Toast.makeText(this, "E-mail already registered", Toast.LENGTH_LONG).show();
                    return;
                }
            }


            //Split the data
            String total = firstName + "%%%%" + lastName + "%%%%" + eMail + "%%%%" + pW;
            myEdit.putString(eMail, total);
            myEdit.commit();

            //Back to MainActivity
            Intent x = new Intent(this, MainActivity.class);
            startActivity(x);
        }
        else
            if(!checkFilled(view))
                Toast.makeText(this, "Not Filled", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Wrong E-mail", Toast.LENGTH_LONG).show();
    }

    //Sign up check - checked filled
    public boolean checkFilled(View view) {
        EditText firstNameET = (EditText) findViewById(R.id.SUFirstNameFeild);
        String firstName = firstNameET.getText().toString();
        EditText lastNameET = (EditText) findViewById(R.id.SULastNameFeild);
        String lastName = lastNameET.getText().toString();
        EditText emailET = (EditText) findViewById(R.id.SUEmailFeild);
        String eMail = emailET.getText().toString();
        EditText pwET = (EditText) findViewById(R.id.SUPWFeild);
        String pW = pwET.getText().toString();

        return (!(firstName.equals(""))) && (!(lastName.equals(""))) && (!(eMail.equals(""))) && (!(pW.equals("")));

    }

    //Go back button
    public void btn_SUBacking(View view) {
        Intent x = new Intent(this, MainActivity.class);
        startActivity(x);
    }

    //Sign up check - Email Validation check
    // From Google
    public static boolean emailValidCheck(String text) {
        boolean x = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = text;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            x = true;
        }

        return x;
    }
}
