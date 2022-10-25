package com.example.battleship_sink;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class Board {

    private BorderPane main;

    
    public Board() {
        main = new BorderPane();
        main.setStyle("-fx-background-color: grey");
        main.setPrefHeight(800);
        main.setPrefWidth(600);

    }


}
