package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Psyduck psyduck = new Psyduck();
        int randEnemy = (int) Math.floor(Math.random() * 4) + 1;


    }
}
