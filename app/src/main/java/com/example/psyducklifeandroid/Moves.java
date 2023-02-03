package com.example.psyducklifeandroid;

public class Moves {

    private String name;
    private String type;
    private double atkpow;
    private int acc;

    public Moves(String name, String type, double atkpow, int acc){
        this.name = name;
        this.type = type;
        this.atkpow = atkpow;
        this.acc = acc;
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

    public double getAtkpow() {
        return atkpow;
    }

    public void setAtkpow(double atkpow) {
        this.atkpow = atkpow;
    }

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }
}

