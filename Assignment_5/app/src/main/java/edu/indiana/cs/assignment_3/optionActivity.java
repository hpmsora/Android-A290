package edu.indiana.cs.assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class optionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        SharedPreferences myColor = getSharedPreferences("Color", MODE_PRIVATE);
        String coloring = myColor.getString("color", "N/A");

        RelativeLayout optLayoutCurr = (RelativeLayout) findViewById(R.id.optLayout);
        optLayoutCurr.setBackgroundColor(Color.parseColor(coloring));

        SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
        String CurrUser = myPref.getString("Current", "N/A");
        String Pinfo = myPref.getString(CurrUser, "N/A");

        String[] PinfoSpliting = Pinfo.split("%%%%");

        TextView optName = (TextView) findViewById(R.id.optNameView);
        TextView optEmail = (TextView) findViewById(R.id.optEMailView);

        optName.setText(PinfoSpliting[1] + ", " + PinfoSpliting[0]);
        optEmail.setText(PinfoSpliting[2]);

    }

    //Go to Calculator activity
    public void OptCalButton(View view) {
        Intent x = new Intent(this, Calculator.class);
        startActivity(x);
    }

    //Go to D-Day activity
    public void OptDDayButton(View view) {
        Intent x = new Intent(this, dDayActivity.class);
        startActivity(x);
    }

    public void optLogOutButton(View view) {
        Intent x = new Intent(this, MainActivity.class);
        startActivity(x);
    }
}
