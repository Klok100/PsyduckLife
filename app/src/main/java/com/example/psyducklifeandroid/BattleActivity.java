package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private static ArrayList<EnemyPokemon> enemyPokemon = new ArrayList<>();
    private static ArrayList<Moves> onixMoves = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Psyduck psyduck = new Psyduck();

        enemyPokemon.add(new EnemyPokemon("Onix", 35, 45, 160, 30, 45, 70));
        enemyPokemon.add(new EnemyPokemon("Starmie", 60, 75, 85, 100, 85, 115 ));
        enemyPokemon.add(new EnemyPokemon("Raichu", 60, 90, 55, 90, 80, 100));
        enemyPokemon.add(new EnemyPokemon("Vileplume", 75, 80, 85, 100, 90, 55));
        enemyPokemon.add(new EnemyPokemon("Venomoth", 70, 65, 60, 90, 75, 90));
        enemyPokemon.add(new EnemyPokemon("Alakazam", 55, 50, 45, 135, 85, 120));
        enemyPokemon.add(new EnemyPokemon("Arcanine", 90, 110, 80, 100, 80, 95));
        enemyPokemon.add(new EnemyPokemon("Nidoqueen", 90, 82, 87, 75, 85, 76));

        onixMoves.add(new Moves("Stone Edge", "rock", 100, 80));


    }
}
