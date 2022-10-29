package com.example.battleship_sink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleshipMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage stage;
    GridPane enemyBoard;
    GridPane playerBoard;
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sink the Battleship");

        //grid x2
        enemyBoard = createGrid();
        playerBoard = createGrid();
        enemyBoard.setPadding(new Insets(20, 20, 20, 20));
        enemyBoard.setAlignment(Pos.CENTER);
        playerBoard.setPadding(new Insets(20, 20, 20, 20));
        playerBoard.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setPrefHeight(800);
        vBox.setPrefWidth(600);
        vBox.setStyle("-fx-background-color: linear-gradient(#e66465, #9198e5);");
        vBox.getChildren().addAll(enemyBoard, playerBoard);

        shootRandomShotAtEnemy();

        //scene, rör ej
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }


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

    public Node getRandomNode (GridPane gridPane, int randRow, int randCol) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == randCol && GridPane.getRowIndex(node) == randRow) {
                return node;
            }
        }
        return null;
    }

    public void shootRandomShotAtEnemy () {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int randRow = (int)Math.floor(Math.random() * 10);
        int randCol = (int)Math.floor(Math.random() * 10);
        Node node = getRandomNode(enemyBoard, randRow, randCol);
        node.setStyle("-fx-background-color: black");
        int columnIndex = GridPane.getColumnIndex(node);
        int rowIndex = GridPane.getRowIndex(node);
        System.out.println("Player 1 shot their shot at " + rows.get(rowIndex) + columns.get(columnIndex));
    }

    /**  DEN HÄR BEHÖVER VI SEN
     * button.setOnAction(new EventHandler<ActionEvent>() {
     *                     @Override
     *                     public void handle(ActionEvent actionEvent) {
     *                         button.setStyle("-fx-background-color: black");
     *
     *                     }
     *                 });
     */
}
