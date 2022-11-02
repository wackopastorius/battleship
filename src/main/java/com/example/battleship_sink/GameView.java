package com.example.battleship_sink;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

/**
 * Author: Lada Egolaeva
 *
 * GameView class is responsible for defining and creating the
 * playing board.
 *
 */

public class GameView {

    //properties
    protected GridPane enemyBoard = createGrid();
    protected GridPane playerBoard = createGrid();

    //constructor

    public GameView(GridPane enemyBoard, GridPane playerBoard) {
        this.enemyBoard = enemyBoard;
        this.playerBoard = playerBoard;
    }

    public GameView() {
    }

    /**
     * createGameView() creates two GridPane objects (player, enemy) and puts them
     * into a VBox with defined properties.
     * This method returns a Vbox with nodes residing inside of it.
     */
    public VBox presentGameView() {
        enemyBoard.setPadding(new Insets(20, 20, 20, 20));
        enemyBoard.setAlignment(Pos.CENTER);
        playerBoard.setPadding(new Insets(20, 20, 20, 20));
        playerBoard.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setPrefHeight(800);
        vBox.setPrefWidth(600);
        vBox.setStyle("-fx-background-color: linear-gradient(#e66465, #9198e5);");
        vBox.getChildren().addAll(enemyBoard, playerBoard);
        return vBox;
    }

    /**
     * createGrid() defines a 10x10 GridPane and populates it with nodes (buttons).
     */
    public GridPane createGrid() {
        GridPane playerGrid = new GridPane();

        for (int i = 0; i < 10; i++) {
            playerGrid.getColumnConstraints().add(new ColumnConstraints(35));
            playerGrid.getRowConstraints().add(new RowConstraints(35));
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button button = new Button();
                button.setPrefHeight(35);
                button.setPrefWidth(35);
                GridPane.setConstraints(button, j, i);
                playerGrid.getChildren().add(button);
            }
        }
        return playerGrid;
    }

    public GridPane getEnemyBoard() {
        return enemyBoard;
    }

    public GridPane getPlayerBoard() {
        return playerBoard;
    }
}