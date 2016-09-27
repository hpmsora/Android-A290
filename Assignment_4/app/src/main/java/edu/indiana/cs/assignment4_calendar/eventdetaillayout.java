package edu.indiana.cs.assignment4_calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;

public class eventdetaillayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetaillayout);
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String text = Pref.getString("Current_item", "N/A");
        String curDate = Pref.getString("Current_Date", "N/A");

        if(!text.equals("0")) {
            SharedPreferences PrefData = getSharedPreferences(curDate, MODE_PRIVATE);
            String[] str = splittingData(PrefData.getString(text, "N/A"));

            EditText title_EditText = (EditText) findViewById(R.id.titleField);
            title_EditText.setText(str[0]);
            EditText startTime_EditText = (EditText) findViewById(R.id.startTimeFeild);
            startTime_EditText.setText(str[1]);
            EditText endTime_EditText = (EditText) findViewById(R.id.endTimeFeild);
            endTime_EditText.setText(str[2]);
            EditText note_EditText = (EditText) findViewById(R.id.noteField);
            note_EditText.setText(str[3]);
        }



    }

    public void backingButton(View view) {

        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String curDate = Pref.getString("Current_Date", "N/A");
        SharedPreferences.Editor myDateEditor = Pref.edit();
        myDateEditor.putString("Current_Date", curDate.substring(0, 3));
        myDateEditor.commit();

        Intent backingButtonIntent = new Intent(eventdetaillayout.this, agendaActivity.class);
        startActivity(backingButtonIntent);
    }

    public void savingButton(View view) {

        EditText title = (EditText) findViewById(R.id.titleField);
        String title_text = title.getText().toString();
        EditText startTime = (EditText) findViewById(R.id.startTimeFeild);
        String startTime_text = startTime.getText().toString();
        EditText endTime = (EditText) findViewById(R.id.endTimeFeild);
        String endTime_text = endTime.getText().toString();
        EditText note = (EditText) findViewById(R.id.noteField);
        String note_text = note.getText().toString();

        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String curDate = Pref.getString("Current_Date", "N/A");


        int actualTime = Integer.parseInt(startTime_text);

        if(actualTime >= 1200) {
            curDate += "_Eve";
        }
        else {
           curDate += "_Mor";
        }


        events event = new events(title_text, Integer.parseInt(startTime_text), Integer.parseInt(endTime_text), note_text);
        SharedPreferences curPrf = getSharedPreferences(curDate, MODE_PRIVATE);
        SharedPreferences.Editor myEditor = curPrf.edit();
        myEditor.putString(startTime_text, event.toString());
        myEditor.commit();



        SharedPreferences.Editor myDateEditor = Pref.edit();
        myDateEditor.putString("Current_Date", curDate.substring(0, 3));
        myDateEditor.commit();

        Intent backingButtonIntent = new Intent(eventdetaillayout.this, agendaActivity.class);
        startActivity(backingButtonIntent);
    }


    //Splitting the data
    public String[] splittingData(String str) {
        return str.split("&&&");
    }

    public void DeletingItemButton(View view) {

        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String text = Pref.getString("Current_item", "N/A");
        String curDate = Pref.getString("Current_Date", "N/A");

        SharedPreferences itemPref = getSharedPreferences(curDate, MODE_PRIVATE);
        SharedPreferences.Editor itemEditor = itemPref.edit();

        itemEditor.remove(text);
        itemEditor.commit();

        SharedPreferences.Editor myDateEditor = Pref.edit();
        myDateEditor.putString("Current_Date", curDate.substring(0, 3));
        myDateEditor.commit();

        Intent backingButtonIntent = new Intent(eventdetaillayout.this, agendaActivity.class);
        startActivity(backingButtonIntent);

    }
}
