package com.shanshka.battleshipssparklyedition.Ships;

public abstract class Ship {
    private int dim;
    private boolean[] hit;
    private int destroyedParts;

    Ship(int dimension){
        dim = dimension;
        destroyedParts = 0;
        hit = new boolean[dim];
        for (int i=0; i<dim; i++){
            hit[i]=false;
        }
    }

    //Schiffskoordinaten von 0-[1-4]
    public void setHitInShip(int coordinate){
        hit[coordinate]=true;
        destroyedParts += 1;
        checkShipStatus();
    }


    //TODO Handling sunken Ship
    private void checkShipStatus(){
        if (destroyedParts == dim){
            //Ship completely destroyed
        }
    }
}
