package com.shanshka.battleshipssparklyedition;

public class Player {
    public String name;
    public long playerID;
    //private int exp;  Aufsetzen einer Datenbank in welcher Player Daten gespeichert werden wäre nötig

    public Player(long id){
        playerID = id;
        //exp=0;
    }

    public void setPlayerData(String name){
        this.name = name;
    }
}
