package com.example.psyducklifeandroid;

public class Psyduck {

    private String name;
    private double hp;
    private int atk;
    private int def;
    private int spatk;
    private int spdef;
    private int level;
    private int exp;
    private int expcap;

    public Psyduck(){
        this.name = "Psyduck";
        this.hp = 50;
        this.atk = 32;
        this.def = 48;
        this.spatk = 65;
        this.spdef = 50;
        this.level = 15;
        this.exp = 0;
        this.expcap = 50;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getHp(){
        return hp;
    }

    public void setHp(double hp){
        this.hp = hp;
    }

    public int getAtk(){
        return atk;
    }

    public void setAtk(int atk){
        this.atk = atk;
    }

    public int getDef(){
        return def;
    }

    public void setDef(int def){
        this.def = def;
    }

    public int getSpatk(){
        return spatk;
    }

    public void setSpatk(int spatk){
        this.spatk = spatk;
    }

    public int getSpdef(){
        return spdef;
    }

    public void setSpdef(int spdef){
        this.spdef = spdef;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExpcap() {
        return expcap;
    }

    public void setExpcap(int expcap) {
        this.expcap = expcap;
    }

    public int getExp(){
        return exp;
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void levelUp(){
        this.hp += 10;
        this.atk += 3;
        this.def += 3;
        this.spatk += 5;
        this.spdef += 5;
        this.level += 1;
        this.exp = 0;
        this.expcap += 10;
    }
}

