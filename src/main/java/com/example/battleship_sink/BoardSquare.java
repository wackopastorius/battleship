package com.example.battleship_sink;

/*
* Author: Mikael Petersson
*
* */

public class BoardSquare {

    private int number;
    private boolean hasShip;
    private boolean hasBeenHit;
    private boolean isEliminated;
    private boolean canPlaceShip;



    public BoardSquare(int number, boolean hasShip, boolean hasBeenHit, boolean canPlaceShip, boolean isEliminated) {
        this.number = number;
        this.hasShip = hasShip;
        this.hasBeenHit = hasBeenHit;
        this.canPlaceShip = canPlaceShip;
        this.isEliminated = isEliminated;
    }
    public BoardSquare(BoardSquare source){
        this.number = source.number;
        this.hasShip = source.hasShip;
        this.hasBeenHit = source.hasBeenHit;
        this.canPlaceShip = source.canPlaceShip;
        this.isEliminated = source.isEliminated;
    }


    public boolean getHasShip() {
        return hasShip;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean getHasBeenHit() {
        return hasBeenHit;
    }

    public void setHasBeenHit(boolean hasBeenHit) {
        this.hasBeenHit = hasBeenHit;
    }

    public boolean getCanPlaceShip() {
        return canPlaceShip;
    }

    public void setCanPlaceShip(boolean canPlaceShip) {
        this.canPlaceShip = canPlaceShip;
    }

    public boolean getisEliminated() {
        return isEliminated;
    }

    public void setisEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }

    @Override
    public String toString() {
        return "BoardSquare{" +
                "number=" + number + "\n" +
                ", hasShip=" + hasShip + "\n" +
                ", hasBeenHit=" + hasBeenHit + "\n" +
                ", isEliminated=" + isEliminated + "\n" +
                ", canPlaceShip=" + canPlaceShip + "\n" +
                '}';
    }
}
