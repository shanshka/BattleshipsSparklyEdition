package com.shanshka.battleshipssparklyedition;


public class Ship {

    public enum Orientation{
        Horizontal,
        Vertical
    }

    private Orientation orientation;
    private Location startField;
    private int size;

    public Ship(Location startField, Orientation o) {
        this.startField = startField;
        this.orientation = o;
    }

    public Location getStartField() {
        return startField;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getSize() {
        return size;
    }
}
