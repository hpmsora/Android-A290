package edu.indiana.cs.assignment_3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
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

    //First name: Won Yong
    //Last name: Ha
    //email: woha@indiana.edu
    public boolean logging() {
        SharedPreferences myPref = getSharedPreferences("Save Data", MODE_PRIVATE);

        String first = myPref.getString("firstname", "Nope");
        String last = myPref.getString("lastname", "Nope");;
        String email = myPref.getString("email", "Nope");;
        Toast.makeText(getBaseContext(), first + " " + last + " " + email, Toast.LENGTH_LONG).show();

        return (first.equals("Won Yong") && last.equals("Ha") && email.equals("woha@indiana.edu"));

    }

    public void log_in(View v) {
        TextView first = (EditText) findViewById(R.id.first_name);
        String first_name = first.getText().toString();
        TextView last = (EditText) findViewById(R.id.last_name);
        String last_name = last.getText().toString();
        TextView email = (EditText) findViewById(R.id.email_jnput);
        String email_text = email.getText().toString();
        if (emailValidCheck(email_text)) {

            SharedPreferences myPref = getSharedPreferences("Save Data", MODE_PRIVATE);
            SharedPreferences.Editor myEditor = myPref.edit();
            myEditor.putString("lastname", last_name);
            myEditor.putString("firstname", first_name);
            myEditor.putString("email", email_text);
            myEditor.putString("color", "#FFCABF");
            myEditor.commit();


            if(logging()) {
                Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(this, Calculator.class);
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

    public void red_btn(View v) {
        SharedPreferences myPref = getSharedPreferences("Save Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPref.edit();
        myEditor.putString("color", "#FFCABF");
        myEditor.commit();
    }

    public void blue_btn(View v) {
        SharedPreferences myPref = getSharedPreferences("Save Data", MODE_PRIVATE);
        SharedPreferences.Editor myEditor = myPref.edit();
        myEditor.putString("color", "#0000FF");
        myEditor.commit();

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
}
