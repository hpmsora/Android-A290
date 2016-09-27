package edu.indiana.cs.hw3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] myListItems = {"Bloomington", "New York City", "Hong Kong", "Seoul", "Los Angeles"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListViewMain();
        registerListViewClicks();
    }
    private void populateListViewMain() {
        //Create an Andapter (to convert strings to view items)
        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myListItems);
        //Configure listView to accept the items in adapter
        ListView myListViewer = (ListView) findViewById(R.id.listViewMain);
        myListViewer.setAdapter(myListAdapter);
    }
    private void registerListViewClicks() {
        ListView myListViewer = (ListView) findViewById(R.id.listViewMain);
        myListViewer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView myClickedView = (TextView) viewClicked;
                myClickedView.getText().toString();
                String message = "You clicked # " + position + " which is " + myClickedView.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                //Checking the case and change the activity
                if(position == 0){
                    Intent myIntent = new Intent(MainActivity.this, BloomingtonActivity.class);
                    startActivity(myIntent);
                }
                if(position == 1){
                    Intent myIntent = new Intent(MainActivity.this, NewYorkActivity.class);
                    startActivity(myIntent);
                }
                if(position == 2){
                    Intent myIntent = new Intent(MainActivity.this, HongKongActivity.class);
                    startActivity(myIntent);
                }
                if(position == 3){
                    Intent myIntent = new Intent(MainActivity.this, SeoulActivity.class);
                    startActivity(myIntent);
                }
                if(position == 4){
                    Intent myIntent = new Intent(MainActivity.this, LosAngelesActivity.class);
                    startActivity(myIntent);
                }

            }
        });
    }
}
