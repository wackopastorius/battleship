package com.example.battleship_sink;
/*
* Main Author: Lada Egolaeva
*
* Co-Author: Mikael Petersson
*
* */

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
import java.util.Scanner;

public class BattleshipMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setTitle("Sink the Battleship");

        Scanner scan = new Scanner(System.in);
        //scene, rör ej
        GameView gameView = new GameView();
        Scene scene = new Scene(gameView.presentGameView());
        GameSession newGame = new GameSession(gameView);
        stage.setScene(scene);
        stage.show();

        Board playerBoard = new Board();
        Board enemyBoard = new Board();
        BoardToGridUpdate testUpdate = new BoardToGridUpdate();
        Turn testTurn = new Turn();

        //use method to populate the 2D Array with BoardSquares numbered from 0-99

        playerBoard.setBoard(playerBoard.makeBoardSquareArray());
        enemyBoard.setBoard(enemyBoard.makeBoardSquareArray());

        //Create a Shipwright to build the ships
        Shipwright shipwright = new Shipwright();

        //Have the shipwright build the ships for each player and return them as an Arraylist

        ArrayList<Ship> serverShips = shipwright.unleashTheShipwrightsMagic();
        ArrayList<Ship> clientShips = shipwright.unleashTheShipwrightsMagic();

        ShipPlacer shipPlacer = new ShipPlacer();
        shipPlacer.plotShips(playerBoard, serverShips);
        shipPlacer.plotShips(enemyBoard, clientShips);

        testTurn.testShot(playerBoard, testTurn.rng());

        System.out.println(Arrays.deepToString(playerBoard.getBoard()));
        System.out.println(Arrays.deepToString(enemyBoard.getBoard()));

//        System.out.println(serverShips.get(0));
//        System.out.println(serverShips.get(1));
//        System.out.println(serverShips.get(2));
//        System.out.println(serverShips.get(3));
//        System.out.println(serverShips.get(4));
//        System.out.println(serverShips.get(5));
//        System.out.println(serverShips.get(6));
//        System.out.println(serverShips.get(7));
//        System.out.println(serverShips.get(8));
//        System.out.println(serverShips.get(9));
//        playerBoard.getBoard()[0][0].setHasBeenHit(true);

        testUpdate.returnGrid(playerBoard, gameView.playerBoard);
        testUpdate.returnGrid(enemyBoard, gameView.enemyBoard);

        testTurn.testShot(playerBoard, testTurn.rng());
        testUpdate.returnGrid(playerBoard, gameView.playerBoard);
//

    }


    public int rng(){
        return (int) (Math.random() * 100);
    }
}





