package com.example.battleship_sink;
/*

* Co-Authors:
* Lada Egolaeva & Mikael Petersson
*
* */

public class Turn {

    public Turn() {
    }

    //shoot a shot



    //public
    public boolean testShot (Board board, int number){
        boolean status = false;
        for (int i = 0; i < board.getBoard().length; i++){
            for (int j = 0; j < board.getBoard()[i].length; j++){
                if(number == board.getBoard()[i][j].getNumber() && board.getBoard()[i][j].getHasShip()){
                    board.getBoard()[i][j].setHasBeenHit(true);
                    System.out.println("got a hit");
                    status = true;
                }
            }
        }
        System.out.println("shot status: " + status);
        return status;
    }




    public boolean gotHit (Board board, int row, int col){
        boolean status = false;
        if (board.getBoard()[row][col].getHasShip()){
            status = true;
        }
        return status;
    }

    public Board firstShit(Board board){
        int randRow = rng();
        int randCol = rng();

        return board;
    }

    public int rng(){
        return (int) (Math.random() * 100);
    }
}
