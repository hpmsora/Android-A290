package edu.indiana.cs.assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static edu.indiana.cs.assignment_3.R.id.email_jnput;

public class MainActivity extends AppCompatActivity {

    String LastNaming = "";
    String FirstNaming = "";
    String Emailing = "";
    String PWing = "";

    static int count = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Default background Color
        SharedPreferences myPref = getSharedPreferences("Color", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPref.edit();

        myEdit.putString("color", "#FFCABF");
        myEdit.commit();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Logging check
    public boolean logging() {
        SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);

        //Registering check
        String info = myPref.getString(Emailing, "!$$!N/A!$$!");

        if(info.equals("!$$!N/A!$$!")) {
            Toast.makeText(this, "E-mail not registered", Toast.LENGTH_LONG).show();
            return false;
        }
        else {
            //check the log in information
            String[] infoSplit = info.split("%%%%"); //split the data
            return FirstNaming.equals(infoSplit[0]) && (LastNaming.equals(infoSplit[1])) && (Emailing.equals(infoSplit[2])) && (PWing.equals(infoSplit[3]));
        }

    }


    //Log in button
    public void log_in(View v) {
        TextView first = (EditText) findViewById(R.id.first_name);
        String first_name = first.getText().toString();
        TextView last = (EditText) findViewById(R.id.last_name);
        String last_name = last.getText().toString();
        TextView email = (EditText) findViewById(R.id.email_jnput);
        String email_text = email.getText().toString();
        TextView pw = (EditText) findViewById(R.id.password_input);
        String pw_text = pw.getText().toString();
        if (emailValidCheck(email_text)) {

            FirstNaming = first_name;
            LastNaming = last_name;
            Emailing = email_text;
            PWing = pw_text;

            if(logging()) {
                SharedPreferences myPref = getSharedPreferences("loggingInfo", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = myPref.edit();
                myEdit.putString("Current", email_text);
                myEdit.commit();
                Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(this, optionActivity.class);
                startActivity(myIntent);
            }
            else {
                count++;
                Toast.makeText(getBaseContext(), "Attempts: " + count, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getBaseContext(), "Wrong Email", Toast.LENGTH_LONG).show();
        }
        if(count > 3) {
            Button btn = (Button) findViewById(R.id.log_in_button);
            btn.setEnabled(false);
        }
    }

    //color button 1 = red
    public void red_btn(View v) {
        SharedPreferences myPref = getSharedPreferences("Color", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPref.edit();

        myEdit.putString("color", "#FFCABF");
        myEdit.commit();

        RelativeLayout x = (RelativeLayout) findViewById(R.id.MainLayout);
        x.setBackgroundColor(Color.parseColor("#FFCABF"));
    }


    //color button 2 = blue
    public void blue_btn(View v) {
        SharedPreferences myPref = getSharedPreferences("Color", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = myPref.edit();

        myEdit.putString("color", "#89D6FF");
        myEdit.commit();

        RelativeLayout x = (RelativeLayout) findViewById(R.id.MainLayout);
        x.setBackgroundColor(Color.parseColor("#89D6FF"));
    }

    //Source from
    //http://stackoverflow.com/questions/6119722/how-to-check-edittexts-text-is-email-address-or-not
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.indiana.cs.assignment_3/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.indiana.cs.assignment_3/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


    //sign up button
    public void signningUp(View view) {
        Intent x = new Intent(this, signUpActivity.class);
        startActivity(x);
    }
}
