package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
    }

    public int attack(View v){

    }

    public void scratch(){
        double enemyAtk = Math.floor(Math.random() * 4) + 1;
        if (enemyAtk == 1){

        }

        else if (enemyAtk == 2){

        }

        else if (enemyAtk == 3){

        }

        else if (enemyAtk == 4){

        }
    }
}
