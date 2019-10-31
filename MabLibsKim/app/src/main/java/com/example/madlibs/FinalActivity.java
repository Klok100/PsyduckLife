package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {

    public static final String MAIN_LIST = "madLibs";
    public static final String MY_NAME = "name";
    public static final String MY_ADJ = "adj";
    public static final String MY_VERSION = "version";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        ArrayList<String> madLibs = intent.getStringArrayListExtra(MAIN_LIST);
        String name = intent.getStringExtra(MY_NAME);
        String adj = intent.getStringExtra(MY_ADJ);
        String version = intent.getStringExtra(MY_VERSION);

        String strToDisplay = name + "'s " + adj + " Mad Lib";
        TextView str = (TextView) findViewById(R.id.nameBanner);
        str.setText(strToDisplay);

        if (version.equals("0"))
        {
            String madLib = "\tIt was the first day of school for " + name + ". He was super " + madLibs.get(12);
                madLib += " because he would finally be able to see his friends again and have fun trading " + madLibs.get(2);
                madLib += ". As " + name + " was " + madLibs.get(8) + " to catch the " + madLibs.get(5) + ", he dropped ";
                madLib += "his " + madLibs.get(15) + " " + madLibs.get(0) + " that he carried everywhere with him. In a ";
                madLib += "moment of panic, " + name + " dropped his " + madLibs.get(16) + " bag, spilling all of his ";
                madLib += madLibs.get(17) + " " + madLibs.get(3) + ". What a great way to start the day! \n\tAt school, ";
                madLib += name + "'s day didn't get any better. During " + madLibs.get(6) + ", " + madLibs.get(13) + " ";
                madLib += madLibs.get(9) + " all of his " + madLibs.get(4) + ", and then during " + madLibs.get(7) + ", Mr. " + madLibs.get(14);
                madLib += " " + madLibs.get(10) + " yelled at " + name + " for forgetting his " + madLibs.get(1) + ". ";
                madLib += "Finally, at the end of school, " + name + " sat on the school " + madLibs.get(5) + " home, ready ";
                madLib += madLibs.get(11) + " for a while.";
            TextView str1 = (TextView) findViewById(R.id.madLib);
            str1.setText(madLib);
        }
        else if (version.equals("1"))
        {
            String madLib = "\tIt was the first day of school for " + name + ". She was super " + madLibs.get(12);
                madLib += " because she would finally be able to see her friends again and have fun trading " + madLibs.get(2);
                madLib += ". As " + name + " was " + madLibs.get(8) + " to catch the " + madLibs.get(5) + ", she dropped ";
                madLib += "her " + madLibs.get(15) + " " + madLibs.get(0) + " that she carried everywhere with her. In a ";
                madLib += "moment of panic, " + name + " dropped her " + madLibs.get(16) + " bag, spilling all of her ";
                madLib += madLibs.get(17) + " " + madLibs.get(3) + ". What a great way to start the day! \n\tAt school, ";
                madLib += name + "'s day didn't get any better. During " + madLibs.get(6) + ", " + madLibs.get(13) + " ";
                madLib += madLibs.get(9) + " all of her " + madLibs.get(4) + ", and then during " + madLibs.get(7) + ", Mr. " + madLibs.get(14);
                madLib += " " + madLibs.get(10) + " yelled at " + name + " for forgetting her " + madLibs.get(1) + ". ";
                madLib += "Finally, at the end of school, " + name + " sat on the school " + madLibs.get(5) + " home, ready ";
                madLib += madLibs.get(11) + " for a while.";
            TextView str1 = (TextView) findViewById(R.id.madLib);
            str1.setText(madLib);
            ;
        }

        Spinner stars = (Spinner) findViewById(R.id.spinner);
        final RatingBar mRatingBar = (RatingBar) findViewById(R.id.rating);
        stars.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("1 Star")) {
                    mRatingBar.setRating(1);
                } else if (selectedItem.equals("2 Stars")) {
                    mRatingBar.setRating(2);
                } else if (selectedItem.equals("3 Stars")) {
                    mRatingBar.setRating(3);
                } else if (selectedItem.equals("4 Stars")) {
                    mRatingBar.setRating(4);
                } else if (selectedItem.equals("5 Stars")) {
                    mRatingBar.setRating(5);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        int starRating = mRatingBar.getNumStars();

    }

    public void wrapUp(View v)
    {
        final RatingBar mRatingBar = (RatingBar) findViewById(R.id.rating);
        float starRating = mRatingBar.getRating();


        Intent intent = getIntent();
        String name = intent.getStringExtra(MY_NAME);
        String adj = intent.getStringExtra(MY_ADJ);

        intent = new Intent(this, WrapUpActivity.class);

        intent.putExtra(WrapUpActivity.MY_RATING, starRating);
        intent.putExtra(WrapUpActivity.MY_NAME, name);
        intent.putExtra(WrapUpActivity.MY_ADJ, adj);

        startActivity(intent);
    }
}

