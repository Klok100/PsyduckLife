package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View v){

    }

    //Intent -> Main Activity
    public void shareInfoToMain(View v) {

        Intent intent = new Intent(this, HomeScreen.class);

        startActivity(intent);

    }

}
