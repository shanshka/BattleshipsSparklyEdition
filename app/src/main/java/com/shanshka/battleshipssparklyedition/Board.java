package com.shanshka.battleshipssparklyedition;

import java.util.LinkedList;
import java.util.List;

public class Board {

    int DIMENSION = 10;
    enum STATES{
        Water,
        Boat,
        WaterHit,
        BoatHit
    }
    STATES[][] boardSituation;
    List<Ship> ships;
    int sunkShips = 0;


    public Board(int dimension) {
        this.DIMENSION = dimension;
        boardSituation  = new STATES[DIMENSION][DIMENSION];

        // Fill boardSituation with Water
        for (STATES[] s_array : boardSituation) {
            for (STATES s : s_array)
                s = STATES.Water;
        }

        ships = new LinkedList<>();
    }


    public void wasHit(Location location) {

        int x = location.getX();
        int y = location.getY();
        STATES s = boardSituation[x][y];
        if (s.equals(STATES.Water)) {
            boardSituation[x][y] = STATES.WaterHit;
        } else if (s.equals(STATES.Boat)){
            boardSituation[x][y] = STATES.BoatHit;
            // TODO: Find the corresponding ship in the list and update it
        } //else: nothing changes. A Double Hit does not affect anything

    }

    public void boatSunk() {
        sunkShips++;
    }

    public boolean gameOver() {
        return (ships.size() == sunkShips);
    }

    public boolean addShip(Ship ship) {
        int boatX = ship.getStartField().getX();
        int boatY = ship.getStartField().getY();
        int boatSize = ship.getSize();
        Ship.Orientation o = ship.getOrientation();

        //Check if rules are followed.

        // Ship Position has to be within the dimensions of the board.
        if (boatX < 0 || boatY < 0)
            return false;
        if (boatX > DIMENSION-1 || boatY > DIMENSION -1)
            return false;
        if (o.equals(Ship.Orientation.Horizontal)) {
            if (boatX+boatSize > DIMENSION-1)
                return false;
        } else {
            if (boatY+boatSize > DIMENSION -1)
                return false;
        }

        // Ship must not touch another ship -> All fields around the ship have to be Water.

        if (o.equals(Ship.Orientation.Horizontal)) {
            if (boatX + boatSize < DIMENSION -1) {
                // Check field right of the ship
                if (boardSituation[boatX + boatSize + 1][boatY].equals(STATES.Boat))
                    return false;

                // Check fields diagonal above and below right of the ship
                if (boatY > 0) {
                    if (boardSituation[boatX + boatSize + 1][boatY - 1].equals(STATES.Boat))
                        return false;
                }
                if (boatY < DIMENSION -1) {
                    if (boardSituation[boatX + boatSize + 1][boatY + 1].equals(STATES.Boat))
                        return false;
                }
            }
            if (boatX > 0) {
                // Check also the field left of the ship
                if (boardSituation[boatX - 1][boatY].equals(STATES.Boat))
                    return false;

                // Check fields diagonal above and below left of the ship
                if (boatY > 0) {
                    if (boardSituation[boatX - 1][boatY - 1].equals(STATES.Boat))
                        return false;
                }
                if (boatY < DIMENSION - 1) {
                    if (boardSituation[boatX - 1][boatY + 1].equals(STATES.Boat))
                        return false;
                }
            }
            if (boatY > 0) {
                // Check the fields above the ship
                for (int i = 0; i < boatSize; i++) {
                    if (boardSituation[boatX + i][boatY - 1].equals(STATES.Boat))
                        return false;
                }
            }
            if (boatY < DIMENSION - 1) {
                // Check the fields below the ship
                for (int i = 0; i < boatSize; i++) {
                    if (boardSituation[boatX + i][boatY + 1].equals(STATES.Boat))
                        return false;
                }

            }
        } else {
            if (boatY + boatSize < DIMENSION -1) {
                // Check field below the ship
                if (boardSituation[boatX][boatY + boatSize + 1].equals(STATES.Boat))
                    return false;

                // Check the fields diagonal left and right below the ship
                if (boatX > 0) {
                    if (boardSituation[boatX - 1][boatY + boatSize + 1].equals(STATES.Boat))
                        return false;
                }
                if (boatX < DIMENSION - 1) {
                    if (boardSituation[boatX + 1][boatY + boatSize + 1].equals(STATES.Boat))
                        return false;
                }
            }
            if (boatY > 0) {
                // Check the field above the ship
                if (boardSituation[boatX][boatY - 1].equals(STATES.Boat))
                    return false;

                // Check the fields diagonal left and right above the ship
                if (boatX > 0) {
                    if (boardSituation[boatX - 1][boatY - 1].equals(STATES.Boat))
                        return false;
                }
                if (boatX < DIMENSION - 1) {
                    if (boardSituation[boatX + 1][boatY - 1].equals(STATES.Boat))
                        return false;
                }
            }
            if (boatX > 0) {
                // Check the fields left of the ship
                for (int i = 0; i < boatSize; i++) {
                    if (boardSituation[boatX - 1][boatY + i].equals(STATES.Boat))
                        return false;
                }

            }
            if (boatX < DIMENSION -1) {
                //Check the fields right of the ship
                for (int i = 0; i < boatSize; i++) {
                    if (boardSituation[boatX + 1][boatY + i].equals(STATES.Boat))
                        return false;
                }

            }
        }


        //If all rules are followed:
        // ship is added to ships
        // boardSituation at the positions of ship are set to Ship.
        ships.add(ship);
        if (o.equals(Ship.Orientation.Horizontal)) {
            for (int i = 0; i < boatSize; i++) {
                boardSituation[boatX+i][boatY] = STATES.Boat;
            }
        } else {
            for (int i = 0; i < boatSize; i++) {
                boardSituation[boatX][boatY+i] = STATES.Boat;
            }
        }
        return true;
    }

}
