package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private static ArrayList<EnemyPokemon> enemyPokemon = new ArrayList<>();
    private static ArrayList<Moves> psyduckMoves = new ArrayList<>();
    private static ArrayList<Moves> onixMoves = new ArrayList<>();
    private static ArrayList<Moves> starmieMoves = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

    }

    @Override
    protected void onStart(){
        super.onStart();
        Psyduck psyduck = new Psyduck();

        enemyPokemon.add(new EnemyPokemon("Onix", "Rock", 35, 45, 160, 30, 45, 70));
        enemyPokemon.add(new EnemyPokemon("Starmie", "Water", 60, 75, 85, 100, 85, 115 ));
        enemyPokemon.add(new EnemyPokemon("Raichu", "Electric", 60, 90, 55, 90, 80, 100));
        enemyPokemon.add(new EnemyPokemon("Vileplume", "Grass", 75, 80, 85, 100, 90, 55));
        enemyPokemon.add(new EnemyPokemon("Venomoth", "Bug", 70, 65, 60, 90, 75, 90));
        enemyPokemon.add(new EnemyPokemon("Alakazam", "Psychic", 55, 50, 45, 135, 85, 120));
        enemyPokemon.add(new EnemyPokemon("Arcanine", "Fire", 90, 110, 80, 100, 80, 95));
        enemyPokemon.add(new EnemyPokemon("Nidoqueen", "Ground", 90, 82, 87, 75, 85, 76));

        psyduckMoves.add(new Moves("Scratch", "Normal", 40, 100));
        psyduckMoves.add(new Moves("Water Pulse", "Water", 60, 100));
        psyduckMoves.add(new Moves("Psychic", "Psychic", 90, 100));
        psyduckMoves.add(new Moves("Ice Beam", "Ice", 90, 100));

        onixMoves.add(new Moves("Stone Edge", "Rock", 100, 80));
        onixMoves.add(new Moves("Earthquake", "Ground", 100, 100));
        onixMoves.add(new Moves("Iron Head", "Steel", 80, 100));
        onixMoves.add(new Moves("Rock Slide", "Rock", 75, 90));
        
        starmieMoves.add(new Moves("Thunderbolt", "Electric", 90, 100));
        starmieMoves.add(new Moves("Ice Beam", "Ice", 90, 100));
        starmieMoves.add(new Moves("Psychic", "Psychic", 90, 100));
        starmieMoves.add(new Moves("Surf", "Psychic", 90, 100));

    }

    public void startBattle(){

    }

}
