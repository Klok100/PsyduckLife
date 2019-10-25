package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void shareInfoToRun(View v) {

        Intent intent = new Intent(this, RunningActivity.class);

        startActivity(intent);

    }

    public void shareInfoToSwim(View v) {

        Intent intent = new Intent(this, SwimmingActivity.class);

        startActivity(intent);

    }

    public void shareInfoToFly(View v) {

        Intent intent = new Intent(this, FlyingActivity.class);

        startActivity(intent);

    }

    public void shareInfoToBattle(View v) {

        int num1, num2;

        try {

            EditText level = (EditText) findViewById(R.id.enterLevel);

            String levelString = level.getText().toString();

            if (levelString.equals("") || Integer.parseInt(levelString) > 20 || Integer.parseInt(levelString) < 1)
            {
                num1 = 0;
                num2 = 50/num1;
            }

            Intent intent = new Intent(this, BattleActivity.class);

            intent.putExtra(BattleActivity.LEVEL, levelString);

            startActivity(intent);
        }

        catch(Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please enter a level for Psyduck within 1 - 20",
                    Toast.LENGTH_SHORT);

            toast.show();
        }

    }
}

