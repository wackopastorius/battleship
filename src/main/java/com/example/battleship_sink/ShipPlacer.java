package com.example.battleship_sink;
/*
Main Author: Mikael Petersson
*
Co-Author: Lada Egolaeva
*
* */
import java.util.ArrayList;

public class ShipPlacer {

    private int[] tempArray;




    //Method to plot a fleet of ships to an empty board, and then save the number och each
    //boardsquare in an arraylist of ships
    public Board plotShips(Board board, ArrayList<Ship> ships) {


        //plot a hangar ship to the board
        setHangarShip(board);
        ships.get(0).setBody(tempArray);
        //plot battleship x 2
        shitPlotPooper(board, 4);
        ships.get(1).setBody(tempArray);
        shitPlotPooper(board, 4);
        ships.get(2).setBody(tempArray);
        //plot cruiser x 3
        shitPlotPooper(board, 3);
        ships.get(3).setBody(tempArray);
        shitPlotPooper(board, 3);
        ships.get(4).setBody(tempArray);
        shitPlotPooper(board, 3);
        ships.get(5).setBody(tempArray);
        //plot subs x 4
        shitPlotPooper(board, 2);
        ships.get(6).setBody(tempArray);
        shitPlotPooper(board, 2);
        ships.get(7).setBody(tempArray);
        shitPlotPooper(board, 2);
        ships.get(8).setBody(tempArray);
        shitPlotPooper(board, 2);
        ships.get(9).setBody(tempArray);


        //return the finished board with all ships placed
        return board;
    }
    //Create a method to place a ship based on size on a board


    public Board shitPlotPooper(Board board, int size){

        int direction;
        while(true) {

            int randRow = randNumGenerator();
            System.out.println(randRow);
            int randCol = randNumGenerator();
            System.out.println(randCol);
            if (checkRightAlt(board, size, randRow, randCol)) {
                direction = 1;
                setShipOnBoard(board, direction, size, randRow, randCol);
                System.out.println("plotted right");
                break;
            } else if (checkLeftAlt(board, size, randRow, randCol)) {
                direction = 2;
                setShipOnBoard(board, direction, size, randRow, randCol);
                System.out.println("plotted left");
                break;
            } else if (checkUpAlt(board, size, randRow, randCol)) {
                direction = 3;
                setShipOnBoard(board, direction, size, randRow, randCol);
                System.out.println("plotted up");
                break;
            } else if (checkDownAlt(board, size, randRow, randCol)) {
                direction = 4;
                setShipOnBoard(board, direction, size, randRow, randCol);
                System.out.println("plotted down");
                break;
            }

        }
        return board;
    }

    public Board setHangarShip (Board board){
        tempArray = new int[5];
        int tempArrayIndex = 0;
        for (int i = 0; i < 5; i++){
            board.getBoard()[0][i].setHasShip(true);
            board.getBoard()[0][i].setCanPlaceShip(false);
            tempArray[tempArrayIndex + i] = board.getBoard()[0][i].getNumber();
            board = eliminateSquaresLeft(board,0, i);
            if (i == 5 - 1){
                board = eliminateRightEnd(board, 0, i);
            }
        }
        return board;
    }
    // make a method to set a ship on the board based on size and direction of plotting, and also to eliminate all relevant squares

    public Board setShipOnBoard(Board board, int direction, int size, int randRow, int randCol){
        tempArray = new int[size];
        int tempArrayIndex = 0;
        //dir 1 = right 2 = left 3 = up 4 = down
        switch(direction){
            case 1:
                //Plotting right
                for (int i = 0; i < size; i++){
                board.getBoard()[randRow][randCol + i].setHasShip(true);
                board.getBoard()[randRow][randCol + i].setCanPlaceShip(false);
                tempArray[tempArrayIndex + i] = board.getBoard()[randRow][randCol + i].getNumber();
                board = eliminateSquaresLeft(board,randRow, randCol + i);
                if (i == size - 1){
                    board = eliminateRightEnd(board, randRow, randCol + i);
                    }
                }
                break;

            case 2:
                //plotting left
                for (int i = 0; i < size; i++){
                    board.getBoard()[randRow][randCol - i].setHasShip(true);
                    board.getBoard()[randRow][randCol - i].setCanPlaceShip(false);
                    tempArray[tempArrayIndex + i] = board.getBoard()[randRow][randCol - i].getNumber();
                    board = eliminateSquaresForLeft(board,randRow, randCol - i);
                    if (i == size - 1){
                        board = eliminateLeftEnd(board, randRow, randCol - i);
                        }
                    }
                break;
            case 3:
                //plotting up
                for (int i = 0; i < size; i++){
                    board.getBoard()[randRow - i][randCol].setHasShip(true);
                    board.getBoard()[randRow - i][randCol].setCanPlaceShip(false);
                    tempArray[tempArrayIndex + i] = board.getBoard()[randRow - i][randCol].getNumber();
                    board = eliminateSquaresUp(board,randRow - i, randCol);
                    if (i == size - 1){
                        board = elimLastUp(board, randRow - i, randCol);
                    }
                }
                break;
                //plot down
            case 4:
                for (int i = 0; i < size; i++){
                    board.getBoard()[randRow + i][randCol].setHasShip(true);
                    board.getBoard()[randRow + i][randCol].setCanPlaceShip(false);
                    tempArray[tempArrayIndex + i] = board.getBoard()[randRow + i][randCol].getNumber();
                    board = eliminateSquaresDown(board,randRow + i, randCol);
                    if (i == 0){
                        board = elimLastDown(board, randRow + i, randCol);
                    }
                }

                break;
            default:
                break;
        }
       return board;
    }

    //check base coordinate and size to the right
    public boolean checkRightAlt (Board board, int size, int randRow, int randCol) {
        boolean check = false;

        //check base coordinate
        if (board.getBoard()[randRow][randCol].getCanPlaceShip() && randCol + size <= 9
                && !board.getBoard()[randRow][randCol].getHasShip()
                && board.getBoard()[randRow][randCol + size].getCanPlaceShip() && !board.getBoard()[randRow][randCol + size].getHasShip()) {
            //If base coordinate open, check all squares of size are available
            for (int i = 0; i <= size; i++) {
                if (board.getBoard()[randRow][randCol + i].getCanPlaceShip() && !board.getBoard()[randRow][randCol + i].getHasShip())
                    System.out.println("checked " + board.getBoard()[randRow][randCol + i].getNumber());
                    check = true;
            }
        }
        System.out.println("right check: " + check);
        return check;
    }

    //check base coordinate and size to the left
    public boolean checkLeftAlt (Board board, int size, int randRow, int randCol){
        boolean check = false;
        if (board.getBoard()[randRow][randCol].getCanPlaceShip() && randCol - size >=0 && !board.getBoard()[randRow][randCol].getHasShip()
        && !board.getBoard()[randRow][randCol - size].getHasShip()){
            for (int i = 0; i <= size; i++){
                if (board.getBoard()[randRow][randCol - i].getCanPlaceShip() && !board.getBoard()[randRow][randCol - i].getHasShip())
                    if (i == size){
                        if (randCol - i == 0 || board.getBoard()[randRow][randCol - (i + 1)].getCanPlaceShip()
                                && !board.getBoard()[randRow][randCol - (i + 1) ].getHasShip()){
                            check = true;
                        }
                    }
            }
        }
        System.out.println("left check: " + check);

        return check;
    }

    //check base coordinate and size vertically up
    public boolean checkUpAlt(Board board, int size, int randRow, int randCol){
        boolean check = false;
            if (board.getBoard()[randRow][randCol].getCanPlaceShip() && randRow - size >= 0 && !board.getBoard()[randRow][randCol].getHasShip()
                    && !board.getBoard()[randRow - size][randCol].getHasShip() && board.getBoard()[randRow - size][randCol].getCanPlaceShip() ){
                for (int i = 0; i <= size; i++){
                    if (board.getBoard()[randRow - i][randCol].getCanPlaceShip() && !board.getBoard()[randRow - i][randCol].getHasShip()){

                        check = true;
                    }
                }
            }
        System.out.println("Up check: " + check);
        return check;
    }

    //Check base coordinate and size vertically down
    public boolean checkDownAlt(Board board, int size, int randRow, int randCol){
        boolean check = false;
        if (board.getBoard()[randRow][randCol].getCanPlaceShip() && randRow + size <= 9
                && !board.getBoard()[randRow][randCol].getHasShip()
                && !board.getBoard()[randRow + size][randCol].getHasShip() && board.getBoard()[randRow + size][randCol].getCanPlaceShip() ){
            for (int i = 0; i <= size; i++){
                if (board.getBoard()[randRow + i][randCol].getCanPlaceShip() && !board.getBoard()[randRow + i][randCol].getHasShip()){
                    check = true;
                }
            }
        }
        System.out.println("Down check: " + check);
        return check;
    }

//

    public int randNumGenerator() {
        double random = Math.random() * 10;
        return (int) random;
    }

    public Board eliminateSquaresUp(Board board, int row, int col){
        //starting from below base coordinate
        //Eliminate below coordinate if not hasShip
        if (row + 1 <= 9 && !board.getBoard()[row + 1][col].getHasShip()){
            board.getBoard()[row + 1][col].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row + 1][col].getNumber() );
        }
        //left diagonal below coordinate
        if (col - 1 >= 0 && row + 1 <= 9 && !board.getBoard()[row + 1][col - 1].getHasShip()){
            board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
            System.out.println("eliminated " + board.getBoard()[row + 1][col - 1].getNumber());
        }
        //right diagonal below coordinate
        if (col + 1 <= 9 && row + 1 <= 9 && !board.getBoard()[row + 1][col + 1].getHasShip()){
            board.getBoard()[row + 1][col + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row + 1][col + 1].getNumber());
        }

        return board;
    }

    public Board eliminateSquaresDown(Board board, int row, int col){
        //starting from below base coordinate
        //Eliminate below coordinate if not hasShip
        if (row - 1 >= 0 && !board.getBoard()[row - 1][col].getHasShip()){
            board.getBoard()[row - 1][col].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row - 1][col].getNumber() );
        }
        //left and right of base
        if (col -1 >= 0){
            board.getBoard()[row][col - 1].setCanPlaceShip(false);
        }
        if (col + 1 <= 9){
            board.getBoard()[row][col + 1].setCanPlaceShip(false);
        }
        //left diagonal below coordinate
        if (col - 1 >= 0 && row + 1 <= 9 && !board.getBoard()[row + 1][col - 1].getHasShip()){
            board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
            System.out.println("eliminated " + board.getBoard()[row + 1][col - 1].getNumber());
        }
        //right diagonal below coordinate
        if (col + 1 <= 9 && row + 1 <= 9 && !board.getBoard()[row + 1][col + 1].getHasShip()){
            board.getBoard()[row + 1][col + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row + 1][col + 1].getNumber());
        }

        return board;
    }

    public Board elimLastUp(Board board, int row, int col){

        if (row - 1 >= 0) {
            board.getBoard()[row - 1][col].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row - 1][col].getNumber());
        }
        if (col - 1 >=0 && row - 1 >= 0) {
            board.getBoard()[row][col - 1].setCanPlaceShip(false);
            board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row][col - 1].getNumber() + " & " + board.getBoard()[row - 1][col - 1].getNumber());
        }
        if (col + 1 <= 9 && row - 1 >= 0){
            board.getBoard()[row - 1][col + 1].setCanPlaceShip(false);
            board.getBoard()[row][col + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row - 1][col + 1].getNumber() + " & " + board.getBoard()[row][col + 1].getNumber());
        }
        return board;
    }

    public Board elimLastDown(Board board, int row, int col){

        //Elim square below last
        if (row + 1 <= 9) {
            board.getBoard()[row + 1][col].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row + 1][col].getNumber());
        }
        //Elim square diagonal left
        if (col - 1 >=0 && row + 1 <= 9) {
            board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[row + 1][col - 1].getNumber());
        }
        if (col + 1 <= 9 && row + 1 <= 9){
            board.getBoard()[row + 1][col + 1].setCanPlaceShip(false);

            System.out.println("eliminated: " + board.getBoard()[row + 1][col + 1].getNumber());
        }
        return board;
    }
    //Method to eliminate possible squares to the left, diagonally, up and down, pair W checkRight
    public Board eliminateSquaresLeft (Board board, int rowIndex, int colIndex){

        // eliminate BS to the left, unless it has a ship or is out of bounds
        if (colIndex - 1 >= 0 && !board.getBoard()[rowIndex][colIndex - 1].getHasShip()){
            board.getBoard()[rowIndex][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex][colIndex - 1].getNumber());
        }
        //check diagonal up back
        if (rowIndex - 1 >= 0 && colIndex - 1 >= 0){
            board.getBoard()[rowIndex -1][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex -1][colIndex - 1].getNumber());
        }
        //check diagonal down left
        if (rowIndex + 1 <= 9 && colIndex - 1 >= 0){
            board.getBoard()[rowIndex + 1][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex - 1].getNumber());
        }
        //check and set up
        if (rowIndex - 1 >= 0){
            board.getBoard()[rowIndex -1][colIndex].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex -1][colIndex].getNumber());
        }
        //check and set down
        if (rowIndex + 1 <= 9){
            board.getBoard()[rowIndex + 1][colIndex].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex].getNumber());
        }
    return board;
    }

    public Board eliminateSquaresForLeft (Board board, int rowIndex, int colIndex){

        // eliminate BS to the right (starting point), unless it has a ship or is out of bounds
        if (colIndex + 1 <= 9 && !board.getBoard()[rowIndex][colIndex + 1].getHasShip()){
            board.getBoard()[rowIndex][colIndex + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex][colIndex + 1].getNumber());
        }
        //check diagonal up back
        if (rowIndex - 1 >= 0 && colIndex + 1 <= 9){
            board.getBoard()[rowIndex -1][colIndex + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex -1][colIndex + 1].getNumber());
        }
        //check diagonal down left
        if (rowIndex + 1 <= 9 && colIndex + 1 <= 9){
            board.getBoard()[rowIndex + 1][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex - 1].getNumber());
        }
        //check and set up
        if (rowIndex - 1 >= 0){
            board.getBoard()[rowIndex -1][colIndex].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex -1][colIndex].getNumber());
        }
        //check and set down
        if (rowIndex + 1 <= 9){
            board.getBoard()[rowIndex + 1][colIndex].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex].getNumber());
        }
        return board;
    }

    //Method to eliminate squares diagonally up and down right
    public Board eliminateRightEnd(Board board, int rowIndex, int colIndex){

        //eliminate last square (right)
        if (colIndex + 1 <= 9) {
            board.getBoard()[rowIndex][colIndex + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex][colIndex + 1].getNumber());
        }
        //Eliminate diagonally up right
        if (rowIndex - 1 >= 0 && colIndex + 1 <= 9){
            board.getBoard()[rowIndex - 1][colIndex + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex - 1][colIndex + 1].getNumber());
        }
        //Eliminate diagonally down right
        if (rowIndex + 1 <= 9 && colIndex + 1 <= 9){
            board.getBoard()[rowIndex + 1][colIndex + 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex + 1].getNumber());
        }

        return board;
    }


    public Board eliminateLeftEnd(Board board, int rowIndex, int colIndex){

        //eliminate last square (left)
        if (colIndex - 1 >= 0) {
            board.getBoard()[rowIndex][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated " + board.getBoard()[rowIndex][colIndex - 1].getNumber());
        }
        //Eliminate diagonally up left
        if (rowIndex - 1 >= 0 && colIndex - 1 >= 0){
            board.getBoard()[rowIndex - 1][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex - 1][colIndex - 1].getNumber());
        }
        //Eliminate diagonally down left
        if (rowIndex + 1 <= 9 && colIndex - 1 >= 0){
            board.getBoard()[rowIndex + 1][colIndex - 1].setCanPlaceShip(false);
            System.out.println("eliminated: " + board.getBoard()[rowIndex + 1][colIndex - 1].getNumber());
        }

        return board;
    }




    }






