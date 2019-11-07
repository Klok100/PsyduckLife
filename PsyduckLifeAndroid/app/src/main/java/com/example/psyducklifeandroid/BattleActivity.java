package com.example.psyducklifeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    public static final String LEVEL = "1";

    private static Psyduck psyduck = new Psyduck();
    private static ArrayList<EnemyPokemon> enemyPokemon = new ArrayList<>();
    private static ArrayList<Moves> psyduckMoves = new ArrayList<>();
    private static ArrayList<Moves> onixMoves = new ArrayList<>();
    private static ArrayList<Moves> starmieMoves = new ArrayList<>();
    private static ArrayList<Moves> raichuMoves = new ArrayList<>();
    private static ArrayList<Moves> vileplumeMoves = new ArrayList<>();
    private static double psyduckOrigHP = 0;
    private static double enemyPokemonOrigHP = 0;

    private static boolean isRunning = true;

    // Creates all of the basic elements on the screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        psyduck.resetStats();
    }

    // Decides what enemy Pokemon the user has to battle based on Psyduck's current level
    public int setEnemy(){
        //int level = psyduck.getLevel();
        ImageView onixImg = (ImageView) findViewById(R.id.onixImage);
        ImageView starmieImage = (ImageView) findViewById(R.id.starmieImage);
        ImageView raichuImage = (ImageView) findViewById(R.id.raichuImage);
        ImageView vileplumeImage = (ImageView) findViewById(R.id.vileplumeImage);
        TextView enemyPokemonHP = (TextView) findViewById(R.id.enemyPokemonHP);

        Intent intent = getIntent();
        String levelString = intent.getStringExtra(LEVEL);
        int levelNum = Integer.parseInt(levelString);

        if (levelNum <= 5){
            onixImg.setVisibility(View.VISIBLE);
            enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(0).getHp()));
            return 0;
        }

        else if (levelNum <= 15){
            starmieImage.setVisibility(View.VISIBLE);
            enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(1).getHp()));
            return 1;
        }

        else if (levelNum <= 15){
            raichuImage.setVisibility(View.VISIBLE);
            enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(2).getHp()));
            return 2;
        }

        else{
            vileplumeImage.setVisibility(View.VISIBLE);
            enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(3).getHp()));
            return 3;
        }
    }

    // Sets the starting HP of both Pokemon
    public void startGame(){
        psyduckOrigHP = psyduck.getHp();
        enemyPokemonOrigHP = enemyPokemon.get(setEnemy()).getHp();
    }

    // After the basic elements of the app have been created in the onCreate, create all of the Pokemon with their given moves
    @Override
    protected void onStart(){
        super.onStart();

        Intent intent = getIntent();
        String levelString = intent.getStringExtra(LEVEL);
        int levelNum = Integer.parseInt(levelString);

        for (int i = 0; i < levelNum; i++){
            psyduck.levelUp();
        }

        TextView psyduckHP = (TextView) findViewById(R.id.psyduckHP);
        psyduckHP.setText("HP: " + String.valueOf(psyduck.getHp()));

        onixMoves.add(new Moves("Stone Edge", "Rock", 100, 80));
        onixMoves.add(new Moves("Earthquake", "Ground", 100, 100));
        onixMoves.add(new Moves("Iron Head", "Steel", 80, 100));
        onixMoves.add(new Moves("Rock Slide", "Rock", 75, 90));

        starmieMoves.add(new Moves("Thunderbolt", "Electric", 90, 100));
        starmieMoves.add(new Moves("Ice Beam", "Ice", 90, 100));
        starmieMoves.add(new Moves("Psychic", "Psychic", 90, 100));
        starmieMoves.add(new Moves("Surf", "Psychic", 90, 100));

        raichuMoves.add(new Moves("Thunder Punch", "Electric", 75, 100));
        raichuMoves.add(new Moves("Iron Tail", "Steel", 100, 75));
        raichuMoves.add(new Moves("Brick Break", "Fighting", 75, 100));
        raichuMoves.add(new Moves("Quick Attack", "Normal", 40, 100));

        vileplumeMoves.add(new Moves("Giga Drain", "Grass", 75, 100));
        vileplumeMoves.add(new Moves("Sludge Bomb", "Poison", 90, 100));
        vileplumeMoves.add(new Moves("Dazzling Gleam", "Fairy", 80, 100));
        vileplumeMoves.add(new Moves("Solar Beam", "Grass", 120, 100));

        enemyPokemon.add(new EnemyPokemon("Onix", "Rock", 5000, 45, 160, 30, 45, onixMoves));
        enemyPokemon.add(new EnemyPokemon("Starmie", "Water", 60, 75, 85, 100, 85, starmieMoves));
        enemyPokemon.add(new EnemyPokemon("Raichu", "Electric", 60, 90, 55, 90, 80, raichuMoves));
        enemyPokemon.add(new EnemyPokemon("Vileplume", "Grass", 75, 80, 85, 100, 90, vileplumeMoves));

        psyduckMoves.add(new Moves("Scratch", "Normal", 40, 100));
        psyduckMoves.add(new Moves("Water Pulse", "Water", 60, 100));
        psyduckMoves.add(new Moves("Psychic", "Psychic", 90, 100));
        psyduckMoves.add(new Moves("Ice Beam", "Ice", 90, 100));

        setEnemy();
        startGame();
    }

    // Generates a random integer based on parameters entered, inclusive
    public int random(int min, int max){
        return (int) (Math.floor(Math.random() * (max - min + 1))) + 1;
    }

    // Uses the accuracy of a given move to see if the move hit or not
    public boolean checkAccuracy(Moves move){
        int accuracy = move.getAcc();
        int random  = random(1, 100);
        if (random <= accuracy){
            return true;
        }
        else{
            return false;
        }
    }

    public double checkAtkPsyduck(Moves move, EnemyPokemon enemy){
        String atkType = move.getType();
        String enemyType = enemy.getType();

        if ((atkType.equals("Ice") && (enemyType.equals("Ground") || (enemyType.equals("Flying") || (enemyType.equals("Grass")) || (enemyType.equals("Dragon")))))
                || (atkType.equals("Water") && (enemyType.equals("Fire") || enemyType.equals("Ground") || enemyType.equals("Rock")))
                || (atkType.equals("Psychic") && (enemyType.equals("Fighting") || enemyType.equals("Poison")))){
            return 2;
        }
        else if ((atkType.equals("Normal") && (enemyType.equals("Rock") || enemyType.equals("Steel")))
                || (atkType.equals("Ice") && (enemyType.equals("Fire") || enemyType.equals("Water") || enemyType.equals("Ice") || enemyType.equals("Steel")))
                || (atkType.equals("Water") && (enemyType.equals("Water") || enemyType.equals("Grass") || enemyType.equals("Dragon")))
                || (atkType.equals("Psychic") && (enemyType.equals("Psychic") || enemyType.equals("Steel")))){
            return 0.5;
        }

        else if ((atkType.equals("Normal") && (enemyType.equals("Ghost")))
                || (atkType.equals("Psychic") && (enemyType.equals("Dark")))){
            return 0;
        }

        else{
            return 1;
        }
    }


    public double checkAtkEnemy(Moves move){
        String atkType = move.getType();
        String psyduckType = psyduck.getType();

        if ((psyduckType.equals("Water") && (atkType.equals("Grass") || atkType.equals("Electric")))){
            return 2;
        }

        else if ((psyduckType.equals("Water") && (atkType.equals("Fire") || atkType.equals("Water") || atkType.equals("Ice") || atkType.equals("Steel")))){
            return 0.5;
        }

        else{
            return 1;
        }
    }


    public void psyduckAtk(EnemyPokemon enemy, TextView enemyPokemonHP, Moves move, TextView psyduckMsg, TextView enemyMsg, double enemyPokemonOrigHP){
        ImageView backButton = (ImageView) findViewById(R.id.backButton);

        if (checkAccuracy(move)){
            double multiplier = checkAtkPsyduck(move, enemy);
            double psyduckBaseDmg = move.getAtkpow();
            double psyduckBaseAtk = psyduck.getAtk();
            double psyduckDmg = psyduckBaseDmg * psyduckBaseAtk;
            double enemyDef = enemy.getDef();
            double psyduckTotalDmg = Math.round((psyduckDmg / 100 * (psyduckBaseAtk / enemyDef)) * multiplier);
            enemy.setHp(Math.round(enemy.getHp() - psyduckTotalDmg));
            enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(setEnemy()).getHp()));
            if (multiplier == 2){
                psyduckMsg.setText("Psyduck used " + move.getName() + " and dealt " + psyduckTotalDmg + " damage to " + enemy.getName() + "! \nIt was super effective!");
            }

            else if (multiplier == 1){
                psyduckMsg.setText("Psyduck used " + move.getName() + " and dealt " + psyduckTotalDmg + " damage to " + enemy.getName() + "!");
            }

            else if (multiplier == 0.5){
                psyduckMsg.setText("Psyduck used " + move.getName() + " and dealt " + psyduckTotalDmg + " damage to " + enemy.getName() + "... \nIt was not very effective.");
            }

            else {
                psyduckMsg.setText("Psyduck used " + move.getName() + " on " + enemy.getName() + "... \nIt had no effect.");
            }

            if(enemyPokemon.get(setEnemy()).getHp() <= 0){
                enemyPokemon.get(setEnemy()).setHp(0);
                enemyPokemonHP.setText("HP: " + String.valueOf(enemyPokemon.get(setEnemy()).getHp()));
                enemyPokemon.get(setEnemy()).setHp(enemyPokemonOrigHP);
                isRunning = false;
                psyduckMsg.setText(enemy.getName() + " fainted. You won the battle!");
                enemyMsg.setText("");
                backButton.setVisibility(View.VISIBLE);
            }
        }

        else{
            psyduckMsg.setText("Psyduck used " + move.getName() + ", but the attack missed!");
        }
    }

    public void enemyAtk(EnemyPokemon enemy, TextView psyduckHP, Moves enemyMove, TextView psyduckMsg, TextView enemyMsg, double psyduckOrigHP){
        ImageView backButton = (ImageView) findViewById(R.id.backButton);


        if (checkAccuracy(enemyMove)){
            double multiplier = checkAtkEnemy(enemyMove);
            double enemyBaseDmg = enemyMove.getAtkpow();
            double enemyBaseAtk = enemy.getAtk();
            double enemyDmg = enemyBaseDmg * enemyBaseAtk;
            double psyduckDef = psyduck.getDef();
            double enemyTotalDmg = Math.round((enemyDmg / 100 * (enemyBaseAtk / psyduckDef)) * multiplier);
            psyduck.setHp(Math.round(psyduck.getHp() - enemyTotalDmg));
            psyduckHP.setText("HP: " + String.valueOf(psyduck.getHp()));
            if (multiplier == 2){
                enemyMsg.setText(enemy.getName() + " used " + enemyMove.getName() + " and dealt " + enemyTotalDmg + " to Psyduck! \nIt was super effective!");
            }

            else if (multiplier == 1){
                enemyMsg.setText(enemy.getName() + " used " + enemyMove.getName() + " and dealt " + enemyTotalDmg + " to Psyduck!");
            }

            else if (multiplier == 0.5){
                enemyMsg.setText(enemy.getName() + " used " + enemyMove.getName() + " and dealt " + enemyTotalDmg + " to Psyduck... \nIt was not very effective.");
            }

            if (psyduck.getHp() <= 0) {
                psyduck.setHp(0);
                psyduckHP.setText("HP: " + String.valueOf(psyduck.getHp()));
                psyduck.setHp(psyduckOrigHP);
                isRunning = false;
                psyduckMsg.setText("Psyduck fainted... You lost the battle!");
                enemyMsg.setText("");
                backButton.setVisibility(View.VISIBLE);
            }
        }

        else{
            enemyMsg.setText(enemy.getName() + " used " + enemyMove.getName() + ", but the attack missed!");
        }
    }

    public void scratch(View v){
        if(isRunning){
            TextView enemyPokemonHP = (TextView) findViewById(R.id.enemyPokemonHP);
            TextView psyduckHP = (TextView) findViewById(R.id.psyduckHP);
            TextView psyduckMsg = (TextView) findViewById(R.id.psyduckAtkMsg);
            TextView enemyMsg = (TextView) findViewById(R.id.enemyAtkMsg);

            EnemyPokemon enemy = enemyPokemon.get(setEnemy());

            Moves scratch = psyduckMoves.get(0);
            psyduckAtk(enemy, enemyPokemonHP, scratch, psyduckMsg, enemyMsg, enemyPokemonOrigHP);

            Moves enemyMove = enemy.getEnemyMoves().get(random(0, 3));
            enemyAtk(enemy, psyduckHP, enemyMove, psyduckMsg, enemyMsg, psyduckOrigHP);
        }
    }

    public void waterpulse(View v){
        if(isRunning){
            TextView enemyPokemonHP = (TextView) findViewById(R.id.enemyPokemonHP);
            TextView psyduckHP = (TextView) findViewById(R.id.psyduckHP);
            TextView psyduckMsg = (TextView) findViewById(R.id.psyduckAtkMsg);
            TextView enemyMsg = (TextView) findViewById(R.id.enemyAtkMsg);

            EnemyPokemon enemy = enemyPokemon.get(setEnemy());

            Moves waterpulse = psyduckMoves.get(1);
            psyduckAtk(enemy, enemyPokemonHP, waterpulse, psyduckMsg, enemyMsg, enemyPokemonOrigHP);

            Moves enemyMove = enemy.getEnemyMoves().get(random(0, 3));
            enemyAtk(enemy, psyduckHP, enemyMove, psyduckMsg, enemyMsg, psyduckOrigHP);
        }
    }

    public void psychic(View v){
        if(isRunning){
            TextView enemyPokemonHP = (TextView) findViewById(R.id.enemyPokemonHP);
            TextView psyduckHP = (TextView) findViewById(R.id.psyduckHP);
            TextView psyduckMsg = (TextView) findViewById(R.id.psyduckAtkMsg);
            TextView enemyMsg = (TextView) findViewById(R.id.enemyAtkMsg);

            EnemyPokemon enemy = enemyPokemon.get(setEnemy());


            Moves psychic = psyduckMoves.get(2);
            psyduckAtk(enemy, enemyPokemonHP, psychic, psyduckMsg, enemyMsg, enemyPokemonOrigHP);

            Moves enemyMove = enemy.getEnemyMoves().get(random(0, 3));
            enemyAtk(enemy, psyduckHP, enemyMove, psyduckMsg, enemyMsg, psyduckOrigHP);
        }
    }

    public void icebeam(View v){
        if(isRunning){
            TextView enemyPokemonHP = (TextView) findViewById(R.id.enemyPokemonHP);
            TextView psyduckHP = (TextView) findViewById(R.id.psyduckHP);
            TextView psyduckMsg = (TextView) findViewById(R.id.psyduckAtkMsg);
            TextView enemyMsg = (TextView) findViewById(R.id.enemyAtkMsg);

            EnemyPokemon enemy = enemyPokemon.get(setEnemy());

            Moves icebeam = psyduckMoves.get(3);
            psyduckAtk(enemy, enemyPokemonHP, icebeam, psyduckMsg, enemyMsg, enemyPokemonOrigHP);

            Moves enemyMove = enemy.getEnemyMoves().get(random(0, 3));
            enemyAtk(enemy, psyduckHP, enemyMove, psyduckMsg, enemyMsg, psyduckOrigHP);
        }
    }

    public void goBack(View v){
        isRunning = true;
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}



