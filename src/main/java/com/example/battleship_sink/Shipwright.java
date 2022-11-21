package com.example.battleship_sink;

/*
* Author: Mikael Petersson
*
* */

import java.util.ArrayList;

public class Shipwright {

    //Class to create a fleet of ships and put them in an ArrayList.

    //Method to create all the ships for a player, and return them as an ArrayList

    public ArrayList<Ship> unleashTheShipwrightsMagic(){

        ArrayList<Ship> ships = new ArrayList<>();
                ships.add(new Ship(new int[5], false));
                ships.add(new Ship (new int[4], false));
                ships.add(new Ship(new int[4], false));
                ships.add(new Ship(new int[3], false));
                ships.add(new Ship(new int[3], false));
                ships.add(new Ship(new int[3], false));
                ships.add(new Ship(new int[2], false));
                ships.add(new Ship(new int[2], false));
                ships.add(new Ship(new int[2], false));
                ships.add(new Ship(new int[2], false));
                return ships;

    }
}
