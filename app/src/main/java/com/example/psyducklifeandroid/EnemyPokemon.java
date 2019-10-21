package com.example.psyducklifeandroid;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EnemyPokemon {

    public String name;
    public int hp;
    public int atk;
    public int def;
    public int spatk;
    public int spdef;
    public int spd;
    public ArrayList<EnemyPokemon> enemyPokemon = new ArrayList<>();

    public EnemyPokemon(String name, int hp, int atk, int def, int spatk, int spdef, int spd){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.spd = spd;
        enemyPokemon.add(new EnemyPokemon("Onix", 35, 45, 160, 30, 45, 70));
        enemyPokemon.add(new EnemyPokemon("Starmie", 60, 75, 85, 100, 85, 115 ));
        enemyPokemon.add(new EnemyPokemon("Raichu", 60, 90, 55, 90, 80, 100));
        enemyPokemon.add(new EnemyPokemon("Vileplume", 75, 80, 85, 100, 90, 55));
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
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

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

}
