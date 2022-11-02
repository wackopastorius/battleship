package com.example.battleship_sink;

import java.util.Arrays;

public class Fleet {
    private Ship[] ships;



    //Constructor

    public Fleet() {
        //Constructor instantly creates all ships for client/server fleet.
        this.ships = new Ship[] {
                new Ship(new String[5], "hangar"),
                new Ship (new String[4], "battleShip1"), new Ship(new String[4], "battleShip2"),
                new Ship(new String[3], "cruiser1"), new Ship(new String[3], "cruiser2"), new Ship(new String[3], "cruiser3"),
                new Ship(new String[2] , "subMarine1"), new Ship(new String[2], "subMarine2"),
                new Ship(new String[2], "subMarine3"), new Ship(new String[2] , "subMarine4")
        };

    }


    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public void assignCoordinatesToShips(String[] shipType){
        this.ships[0].setBody(shipType);

    }



    @Override
    public String toString() {
        return "Fleet{" +
                "ships=" + Arrays.toString(ships) +
                '}';
    }
}