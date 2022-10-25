package com.example.battleship_sink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sink the Battleship");

        //grid x2
        GridPane enemyBoard = createGrid();
        GridPane playerBoard = createGrid();
        enemyBoard.setPadding(new Insets(20, 20, 20, 20));
        enemyBoard.setAlignment(Pos.CENTER);
        playerBoard.setPadding(new Insets(20, 20, 20, 20));
        playerBoard.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.setPrefHeight(800);
        vBox.setPrefWidth(600);
        vBox.setStyle("-fx-background-color: linear-gradient(#e66465, #9198e5);");
        vBox.getChildren().addAll(enemyBoard, playerBoard);

        //scene, rör ej
        Scene scene = new Scene(vBox);
        //scene.getStylesheets().add("Style.css");
        stage.setScene(scene);
        stage.show();
    }

    public GridPane createGrid() {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
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

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        button.setStyle("-fx-background-color: red");
                        int columnIndex = GridPane.getColumnIndex(button);
                        int rowIndex = GridPane.getRowIndex(button);
                        System.out.println("___  shot their shot at " + rows.get(rowIndex) + columns.get(columnIndex));
                    }
                });
            }
        }
        return playerGrid;
    }
}
