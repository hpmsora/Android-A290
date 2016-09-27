package edu.indiana.cs.assignment4_calendar;

import android.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Owl on 9/24/16.
 */
public class FragmentHome extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homelayout, container, false);

        int a = Calendar.getInstance().get(Calendar.DATE);
        if (Calendar.getInstance().get(Calendar.MONTH) == 9)
            a += 2;
        if (a % 7 == 4)
            view.findViewById(R.id.sun).setBackgroundResource(R.color.lightBlue);
        else if (a % 7 == 5)
            view.findViewById(R.id.mon_grid).setBackgroundResource(R.color.lightBlue);
        else if (a % 7 == 6)
            view.findViewById(R.id.tue).setBackgroundResource(R.color.lightBlue);
        else if (a % 7 == 0)
            view.findViewById(R.id.wed).setBackgroundResource(R.color.lightBlue);
        else if (a % 7 == 1)
            view.findViewById(R.id.thu).setBackgroundResource(R.color.lightBlue);
        else if (a % 7 == 2)
            view.findViewById(R.id.fri).setBackgroundResource(R.color.lightBlue);
        else
            view.findViewById(R.id.sat).setBackgroundResource(R.color.lightBlue);


        showCourseCount(view);

        return view;
    }

    //Showing the course count on the Calendar
    public void showCourseCount(View view){

        SharedPreferences sunMor = this.getActivity().getSharedPreferences("Sun_Mor", Context.MODE_PRIVATE);
        SharedPreferences sunEve = this.getActivity().getSharedPreferences("Sun_Eve", Context.MODE_PRIVATE);
        SharedPreferences monMor = this.getActivity().getSharedPreferences("Mon_Mor", Context.MODE_PRIVATE);
        SharedPreferences monEve = this.getActivity().getSharedPreferences("Mon_Eve", Context.MODE_PRIVATE);
        SharedPreferences tueMor = this.getActivity().getSharedPreferences("Tue_Mor", Context.MODE_PRIVATE);
        SharedPreferences tueEve = this.getActivity().getSharedPreferences("Tue_Eve", Context.MODE_PRIVATE);
        SharedPreferences wedMor = this.getActivity().getSharedPreferences("Wed_Mor", Context.MODE_PRIVATE);
        SharedPreferences wedEve = this.getActivity().getSharedPreferences("Wed_Eve", Context.MODE_PRIVATE);
        SharedPreferences thuMor = this.getActivity().getSharedPreferences("Thu_Mor", Context.MODE_PRIVATE);
        SharedPreferences thuEve = this.getActivity().getSharedPreferences("Thu_Eve", Context.MODE_PRIVATE);
        SharedPreferences friMor = this.getActivity().getSharedPreferences("Fri_Mor", Context.MODE_PRIVATE);
        SharedPreferences friEve = this.getActivity().getSharedPreferences("Fri_Eve", Context.MODE_PRIVATE);
        SharedPreferences satMor = this.getActivity().getSharedPreferences("Sat_Mor", Context.MODE_PRIVATE);
        SharedPreferences satEve = this.getActivity().getSharedPreferences("Sat_Mor", Context.MODE_PRIVATE);

        TextView sunMor_TextView = (TextView) view.findViewById(R.id.sun_mor);
        sunMor_TextView.setText(Integer.toString(sunMor.getAll().size()));
        TextView sunEve_TextView = (TextView) view.findViewById(R.id.sun_eve);
        sunEve_TextView.setText(Integer.toString(sunEve.getAll().size()));
        TextView monMor_TextView = (TextView) view.findViewById(R.id.mon_mor);
        monMor_TextView.setText(Integer.toString(monMor.getAll().size()));
        TextView monEve_TextView = (TextView) view.findViewById(R.id.mon_eve);
        monEve_TextView.setText(Integer.toString(monEve.getAll().size()));
        TextView tueMor_TextView = (TextView) view.findViewById(R.id.tue_mor);
        tueMor_TextView.setText(Integer.toString(tueMor.getAll().size()));
        TextView tueEve_TextView = (TextView) view.findViewById(R.id.tue_eve);
        tueEve_TextView.setText(Integer.toString(tueEve.getAll().size()));
        TextView wedMor_TextView = (TextView) view.findViewById(R.id.wed_mor);
        wedMor_TextView.setText(Integer.toString(wedMor.getAll().size()));
        TextView wedEve_TextView = (TextView) view.findViewById(R.id.wed_eve);
        wedEve_TextView.setText(Integer.toString(wedEve.getAll().size()));
        TextView thuMor_TextView = (TextView) view.findViewById(R.id.thu_mor);
        thuMor_TextView.setText(Integer.toString(thuMor.getAll().size()));
        TextView thuEve_TextView = (TextView) view.findViewById(R.id.thu_eve);
        thuEve_TextView.setText(Integer.toString(thuEve.getAll().size()));
        TextView friMor_TextView = (TextView) view.findViewById(R.id.fri_mor);
        friMor_TextView.setText(Integer.toString(friMor.getAll().size()));
        TextView friEve_TextView = (TextView) view.findViewById(R.id.fri_eve);
        friEve_TextView.setText(Integer.toString(friEve.getAll().size()));
        TextView satMor_TextView = (TextView) view.findViewById(R.id.sat_mor);
        satMor_TextView.setText(Integer.toString(satMor.getAll().size()));
        TextView satEve_TextView = (TextView) view.findViewById(R.id.sat_eve);
        satEve_TextView.setText(Integer.toString(satEve.getAll().size()));



    }


}
