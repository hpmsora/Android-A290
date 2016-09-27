package edu.indiana.cs.assignment4_calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class agendaActivity extends AppCompatActivity {

    ArrayList<String> ls = new ArrayList<String>();
    ArrayList<String> ls_title = new ArrayList<String>();
    ArrayList<String> ls_endTime = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String currentDateAgenda = Pref.getString("Current_Date", "N/A");
        SharedPreferences currentAgenda = getSharedPreferences(currentDateAgenda+"_Mor", MODE_PRIVATE);

        Map<String, ?> keys1 = currentAgenda.getAll();
        for(Map.Entry<String, ?> entry : keys1.entrySet()) {
            String contentInside = currentAgenda.getString(entry.getKey(), "N/A");
            String[] contentsInside = splittingData(contentInside);
            ls_title.add(contentsInside[0]);
            ls_endTime.add(contentsInside[2]);
            ls.add(entry.getKey());
        }

        currentAgenda = getSharedPreferences(currentDateAgenda+"_Eve", MODE_PRIVATE);

        Map<String, ?> keys2 = currentAgenda.getAll();
        for(Map.Entry<String, ?> entry : keys2.entrySet()) {
            String contentInside = currentAgenda.getString(entry.getKey(), "N/A");
            String[] contentsInside = splittingData(contentInside);
            ls_title.add(contentsInside[0]);
            ls_endTime.add(contentsInside[2]);
            ls.add(entry.getKey());
        }

        ArrayAdapter<String> agendaAdapter = new agendaListAdapter();
        ListView agendaView = (ListView) findViewById(R.id.agendaList);
        agendaView.setAdapter(agendaAdapter);

    }



    public void addNewEvent(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_item", "0");
        myEditor.commit();

        Intent addNewEvent = new Intent(agendaActivity.this, eventdetaillayout.class);
        startActivity(addNewEvent);

    }

    public void backingHomeButton(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        myEditor.putString("Current_item", "0");
        myEditor.commit();

        Intent backingHomeButtonIntent = new Intent(agendaActivity.this, MainActivity.class);
        startActivity(backingHomeButtonIntent);
    }

    public void showingDetail(View view) {

        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = Pref.edit();
        TextView s = (TextView) view.findViewById(R.id.item);
        String nameItem = (String) s.getText();

        int actualTime = Integer.parseInt(nameItem);

        if(actualTime >= 1200) {
            String sufixName = Pref.getString("Current_Date", "N/A");
            sufixName = sufixName + "_Eve";
            myEditor.putString("Current_Date", sufixName);
            myEditor.commit();
        }
        else {
            String sufixName = Pref.getString("Current_Date", "N/A");
            sufixName = sufixName + "_Mor";
            myEditor.putString("Current_Date", sufixName);
            myEditor.commit();
        }

        myEditor.putString("Current_item", nameItem);
        myEditor.commit();

        Intent addNewEvent = new Intent(agendaActivity.this, eventdetaillayout.class);
        startActivity(addNewEvent);

    }

    public void DeletingAllButton(View view) {
        SharedPreferences Pref = getSharedPreferences("Current||Data", MODE_PRIVATE);
        String currentDateAgenda = Pref.getString("Current_Date", "N/A");

        SharedPreferences Date;
        SharedPreferences.Editor myEditor;
        Date = getSharedPreferences(currentDateAgenda+"_Mor", MODE_PRIVATE);
        myEditor = Date.edit();
        myEditor.clear();
        myEditor.commit();
        Date = getSharedPreferences(currentDateAgenda+"_Eve", MODE_PRIVATE);
        myEditor = Date.edit();
        myEditor.clear();
        myEditor.commit();

        Intent refreshingButton = new Intent(agendaActivity.this, agendaActivity.class);
        startActivity(refreshingButton);

    }

    private class agendaListAdapter extends ArrayAdapter<String> {
        public agendaListAdapter() {
            super(agendaActivity.this, R.layout.itemlayout, ls);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //return super.getView(position, convertView, parent);
            View itemView = convertView;
            if(itemView == null)
                itemView = getLayoutInflater().inflate(R.layout.itemlayout, parent, false);
            String x = ls.get(position);
            String titleString = ls_title.get(position);
            String endTimeString = ls_endTime.get(position);

            TextView viewText = (TextView) itemView.findViewById(R.id.item);
            viewText.setText( x);

            TextView endTime_viewText = (TextView) itemView.findViewById(R.id.endTimeSession);
            endTime_viewText.setText(endTimeString);

            TextView title_viewText = (TextView) itemView.findViewById(R.id.titleSession);
            title_viewText.setText(titleString);

            return itemView;
        }
    }
    //Splitting the data
    public String[] splittingData(String str) {
        return str.split("&&&");
    }
}
