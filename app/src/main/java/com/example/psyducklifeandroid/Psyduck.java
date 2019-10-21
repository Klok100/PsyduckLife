package com.example.psyducklifeandroid;

public class Psyduck {

    public String name;
    public int hp;
    public int atk;
    public int def;
    public int spatk;
    public int spdef;
    public int spd;
    public int exp;
    public int expcap;

    public Psyduck(){
        this.name = "Psyduck";
        this.hp = 50;
        this.atk = 52;
        this.def = 48;
        this.spatk = 65;
        this.spdef = 50;
        this.spd = 55;
        this.exp = 0;
        this.expcap = 50;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHp(){
        return hp;
    }

    public void setHp(int hp){
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

    public int getSpd(){
        return spd;
    }

    public void setSpd(int spd){
        this.spd = spd;
    }

    public int getExp(){
        return exp;
    }

    public void setExp(int exp){
        this.exp = exp;
    }


}
