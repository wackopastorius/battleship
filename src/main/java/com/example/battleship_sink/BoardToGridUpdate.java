package com.example.battleship_sink;

/*
* Co-Authors:
* Lada Egolaeva & Mikael Petersson
*
* */

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class BoardToGridUpdate {
    public BoardToGridUpdate() {
    }

    //method to update GridPane based on server and client board.

    public GridPane returnGrid(Board board, GridPane gridPane){

        GridPane grid = new GridPane();

        for (int i = 0; i < 10; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(35));
            grid.getRowConstraints().add(new RowConstraints(35));
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button();
                button.setPrefHeight(35);
                button.setPrefWidth(35);
                GridPane.setConstraints(button, j, i);
                grid.getChildren().add(button);
            }
        }

        for (int i = 0; i < board.getBoard().length; i ++) {
            for (int j = 0; j < board.getBoard()[i].length; j++){
                if (board.getBoard()[i][j].getHasShip()){
                    Node node = getNode(gridPane, j, i);
                    node.setStyle("-fx-background-color: grey");}

                if ((board.getBoard()[i][j].getHasBeenHit() && !board.getBoard()[i][j].getHasShip())) {
                    Node node = getNode(gridPane, i, j);
                    node.setStyle("-fx-background-color: black");
                }

                 if (board.getBoard()[i][j].getHasShip() && board.getBoard()[i][j].getHasBeenHit()){
                    Node node = getNode(gridPane, i, j);
                    node.setStyle("-fx-background-color: red");
                }

            }

        }
        return gridPane;
    }


    public void displayHitShot(GridPane gridPane, boolean status, int i, int j) {
        Node node = getNode(gridPane, i, j);
        if (status) {
            node.setStyle("-fx-background-color: red");
        } else {
            node.setStyle("-fx-background-color: black");
        }
    }

    public Node getNode (GridPane gridPane, int i, int j) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == i && GridPane.getRowIndex(node) == j) {
                return node;
            }
        }
        return null;
    }
}
