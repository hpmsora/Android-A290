package edu.indiana.cs.assignment_3;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
//import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import static java.lang.Math.toIntExact;

public class dDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_day);

        SharedPreferences myColor = getSharedPreferences("Color", MODE_PRIVATE);
        String coloring = myColor.getString("color", "N/A");

        RelativeLayout dDayLayoutCurr = (RelativeLayout) findViewById(R.id.dDayLayout);
        dDayLayoutCurr.setBackgroundColor(Color.parseColor(coloring));

        SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
        String CurrUser = myPref.getString("Current", "N/A");
        String Pinfo = myPref.getString(CurrUser, "N/A");

        String[] PinfoSpliting = Pinfo.split("%%%%");

        TextView dDayName = (TextView) findViewById(R.id.dDayNameTextVeiw);
        TextView dDayEMail = (TextView) findViewById(R.id.dDayEMailTextVeiw);

        dDayName.setText(PinfoSpliting[1] + ", " + PinfoSpliting[0]);
        dDayEMail.setText(PinfoSpliting[2]);

        if(PinfoSpliting.length > 3) {
            Toast.makeText(this, "You should put some D-Day", Toast.LENGTH_LONG).show();
        }
        else {
            EditText dYearField = (EditText) findViewById(R.id.dDayYearField);
            EditText dMonthField = (EditText) findViewById(R.id.dDayMonthField);
            EditText dDayField = (EditText) findViewById(R.id.dDayDayField);
            dYearField.setText(PinfoSpliting[4]);
            dMonthField.setText(PinfoSpliting[5]);
            dDayField.setText(PinfoSpliting[6]);

        }

    }

    public void btn_DDayBacking(View view) {
        Intent x = new Intent(this, optionActivity.class);
        startActivity(x);
    }

    public void btn_DDayLogOuting(View view) {
        Intent x = new Intent(this, MainActivity.class);
        startActivity(x);
    }

    public void btn_DDaySubmiting(View view) {
        EditText dYearField = (EditText) findViewById(R.id.dDayYearField);
        EditText dMonthField = (EditText) findViewById(R.id.dDayMonthField);
        EditText dDayField = (EditText) findViewById(R.id.dDayDayField);
        int dYear = Integer.parseInt(dYearField.getText().toString());
        int dMonth = Integer.parseInt(dMonthField.getText().toString());
        int dDay = Integer.parseInt(dDayField.getText().toString());

        String DayFormat = dMonth + "/" + dDay + "/" + dYear;

        Calendar DateCurr = Calendar.getInstance();
        DateCurr.set(Calendar.DAY_OF_MONTH, dDay);
        DateCurr.set(Calendar.MONTH, dMonth - 1);
        DateCurr.set(Calendar.YEAR, dYear);

        if(isValidDate(DayFormat)) {
            long CurrMili = java.util.Calendar.getInstance().getTimeInMillis();
            long InPutMili = DateCurr.getTimeInMillis();
            long Diff = InPutMili - CurrMili;
            Diff = Diff / 3600 / 24 / 1000;

            Calendar StandardDate = Calendar.getInstance();
            StandardDate.set(Calendar.YEAR, 2016);
            StandardDate.set(Calendar.DAY_OF_MONTH, 1);
            StandardDate.set(Calendar.MONTH, 0);

            long StandMili = StandardDate.getTimeInMillis();
            long StandDiff = CurrMili - StandMili;

            StandDiff = StandDiff / 3600 / 24 / 1000;
            int CurrentDate = ((int) StandDiff) % 7;

            int weekDay = 0;
            int weekendDay = 0;

            for (int i = CurrentDate + 2; i <= Diff + CurrentDate + 1; i++) {
                int d = i % 7;
                if (d == 1 || d == 0)
                    weekendDay++;
                else
                    weekDay++;
            }

            TextView RDate = (TextView) findViewById(R.id.dDayRemailDate);
            RDate.setText("Weekdays: " + weekDay + "   Weekend days: " + weekendDay);

            SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
            String CurrUser = myPref.getString("Current", "N/A");
            String Pinfo = myPref.getString(CurrUser, "N/A");

            Pinfo = Pinfo + "%%%%" + dYear + "%%%%" + dMonth + "%%%%" + dDay;
            SharedPreferences.Editor myEditor = myPref.edit();
            myEditor.putString(CurrUser, Pinfo);
            myEditor.commit();


        }
        else {
            Toast.makeText(this, "Invalid Date", Toast.LENGTH_LONG).show();
        }



    }

    private static boolean isValidDate(String input) {
        String formatString = "MM/dd/yyyy";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException e) {
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }
}
