package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WrapUpActivity extends AppCompatActivity {

    public static final String MY_RATING = "rating";
    public static final String MY_NAME = "name";
    public static final String MY_ADJ = "adj";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_up);

        Intent intent = getIntent();
        Float starRating = intent.getFloatExtra(MY_RATING, 1);
        String name = intent.getStringExtra(MY_NAME);
        String adj = intent.getStringExtra(MY_ADJ);

        String strToDisplay1 = name + "'s " + adj + " Mad Lib";
        TextView str1 = (TextView) findViewById(R.id.nameBanner);
        str1.setText(strToDisplay1);


        if (starRating == 1)
        {
            String strToDisplay = "Yikes, only 1 star?? Wanna try again and see if it can get better?";
            TextView str = (TextView) findViewById(R.id.ratingAnswer);
            str.setText(strToDisplay);
        }

        else if (starRating == 2)
        {
            String strToDisplay = "2 stars... at least it's not 1. Wanna try again and see if it can get better?";
            TextView str = (TextView) findViewById(R.id.ratingAnswer);
            str.setText(strToDisplay);
        }

        else if (starRating == 3)
        {
            String strToDisplay = "3 stars isn't that bad, but wanna try again and see if it can get better?";
            TextView str = (TextView) findViewById(R.id.ratingAnswer);
            str.setText(strToDisplay);
        }

        else if (starRating == 4)
        {
            String strToDisplay = "4 stars, wow that's pretty impressive! How about trying for that 5 star mad lib?";
            TextView str = (TextView) findViewById(R.id.ratingAnswer);
            str.setText(strToDisplay);
        }

        else
        {
            String strToDisplay = "5 stars congrats!! That must be a gosh darn good mad lib. Let's see if you can get two in a row?";
            TextView str = (TextView) findViewById(R.id.ratingAnswer);
            str.setText(strToDisplay);
        }
    }

    public void restart(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void quit(View v)
    {
        finish();
    }
}
