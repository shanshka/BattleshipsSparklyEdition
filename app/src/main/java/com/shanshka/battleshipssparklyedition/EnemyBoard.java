package com.shanshka.battleshipssparklyedition;

public class EnemyBoard extends Board {
    enum states{
        Water,
        WaterHit,
        BoatHit
    }

    public EnemyBoard(int dimension) {
        super(dimension);
    }


}
