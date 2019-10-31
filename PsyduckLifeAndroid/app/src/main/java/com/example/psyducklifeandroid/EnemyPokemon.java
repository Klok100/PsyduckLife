package com.example.psyducklifeandroid;

import java.util.ArrayList;

public class EnemyPokemon {

    private String name;
    private String type;
    private double hp;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private ArrayList<Moves> enemyMoves;


    public EnemyPokemon(String name, String type, double hp, int atk, int def, int spatk, int spdef, ArrayList<Moves> enemyMoves){
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.enemyMoves = enemyMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpatk() {
        return spatk;
    }

    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    public int getSpdef() {
        return spdef;
    }

    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    public ArrayList<Moves> getEnemyMoves() {
        return enemyMoves;
    }

    public void setEnemyMoves(ArrayList<Moves> enemyMoves) {
        this.enemyMoves = enemyMoves;
    }
}

