package com.example.battleship_sink;
/*
*
* Author: Mikael Petersson
*
* */
import java.util.Arrays;

public class Board {
    private BoardSquare[][] board;

    public Board() {
    }

    public Board(BoardSquare[][] board) {
        this.board = new BoardSquare[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                this.board[i][j] = new BoardSquare(board[i][j]);

            }
        }
    }

    public BoardSquare[][] getBoard() {
        return board;
    }

    public void setBoard(BoardSquare[][] board) {
        this.board = board;
    }
    public BoardSquare[][] makeBoardSquareArray(){
        int tempNum = 0;
        BoardSquare[][] board = new BoardSquare[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++ ){
                board[i][j] = new BoardSquare(tempNum, false, false, true, false);
                tempNum++;
            }
        }
        return board;

    }
    @Override
    public String toString() {
        return "board=" + Arrays.toString(board) + "\n";
    }
}
