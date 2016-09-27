package edu.indiana.cs.assignment4_calendar;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private List<events> eventList = new ArrayList<events>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.FragmentManager myFragmentManager = getFragmentManager();
        android.app.FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
        Configuration configitnfo = getResources().getConfiguration();

        //Default First Page
        FragmentHome myHomeFragment = new FragmentHome();

        myFragmentTransaction.replace(R.id.MainActivityLayOut, myHomeFragment);
        myFragmentTransaction.commit();


    }

    public void sunPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Sun");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void monPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Mon");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void tuePressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Tue");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void wedPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Wed");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void thuPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Thu");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void friPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Fri");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void satPressed(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_Date", "Sat");
        myEditor.commit();
        Intent i = new Intent(MainActivity.this, agendaActivity.class);
        startActivity(i);
    }

    public void homingButton(View view) {
        android.app.FragmentManager myFragmentManager = getFragmentManager();
        android.app.FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
        FragmentHome myHomeFragment = new FragmentHome();
        myFragmentTransaction.replace(R.id.MainActivityLayOut, myHomeFragment);
        myFragmentTransaction.commit();
    }
}
