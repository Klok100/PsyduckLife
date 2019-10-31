package com.example.madlibs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FillActivity extends AppCompatActivity {

    public static final String MY_NAME = "name";
    public static final String MY_ADJ = "adj";
    public static final String MY_VERSION = "-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MY_NAME);
        String adj = intent.getStringExtra(MY_ADJ);

        ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
        ArrayList<String> madLibs = new ArrayList<>();

        for (int i = 22; i < mainLayout.getChildCount(); i++) {
            EditText text = (EditText) mainLayout.getChildAt(i);
            madLibs.add(text.getText().toString());
        }

        Intent intent1 = new Intent(this, FinalActivity.class);
        intent1.putExtra(FinalActivity.MAIN_LIST, madLibs);

        String strToDisplay = name + "'s " + adj + " Mad Lib";
        TextView str = (TextView) findViewById(R.id.nameBanner);
        str.setText(strToDisplay);
    }

    public void sendInfo(View view)
    {
        int num1, num2;
        try {
            Intent intent = getIntent();
            String name = intent.getStringExtra(MY_NAME);
            String adj = intent.getStringExtra(MY_ADJ);
            String version = intent.getStringExtra(MY_VERSION);

            ViewGroup mainLayout = (ViewGroup) findViewById(R.id.mainLayout);
            ArrayList<String> madLibs = new ArrayList<>();

            for (int i = 20; i < mainLayout.getChildCount(); i++) {
                EditText text = (EditText) mainLayout.getChildAt(i);
                madLibs.add(text.getText().toString());
            }

            Intent intent1 = new Intent(this, FinalActivity.class);
            intent1.putExtra(FinalActivity.MAIN_LIST, madLibs);
            intent1.putExtra(FinalActivity.MY_NAME, name);
            intent1.putExtra(FinalActivity.MY_ADJ, adj);
            intent1.putExtra(FinalActivity.MY_VERSION, version);

            for (int i = 0; i < madLibs.size(); i++) {
                if (madLibs.get(i).equals(""))
                {
                    num1 = 0;
                    num2 = 50/num1;
                }
            }

            startActivity(intent1);
        }

        catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please make sure to fill in all of the boxes to create your Mad Lib!",
                    Toast.LENGTH_SHORT);

            toast.show();
        }
    }
}





