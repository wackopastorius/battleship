package com.example.battleship_sink;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
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

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Sink the Battleship");



        //scene, rör ej
        GameView gameView = new GameView();
        Scene scene = new Scene(gameView.presentGameView());
        GameSession newGame = new GameSession(gameView);
        newGame.startGame(stage);
        stage.setScene(scene);
        stage.show();
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
