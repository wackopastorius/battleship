package com.example.battleship_sink;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSession {

    private GameView gameView;
    private List<Node> shotCoordinates = new ArrayList<>();

    public GameSession(GameView gameView) {
        this.gameView = gameView;
    }

    public GameSession() {

    }

    public void startGame(Stage stage) {
        shootRandomShotAtEnemy();
        checkShotCoordinates();
    }

    //slumpar fram x- och y-koordinater och returnerar en random cell
    public Node getRandomNode (GridPane gridPane, int randRow, int randCol) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == randCol && GridPane.getRowIndex(node) == randRow) {
                return node;
            }
        }
        return null;
    }

    //skjuter ett slumpmässigt valt skott på fienden samt skriver ut koordinaterna
    public void shootRandomShotAtEnemy() {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        int randRow = (int)Math.floor(Math.random() * 10);
        int randCol = (int)Math.floor(Math.random() * 10);
        Node node = getRandomNode(gameView.enemyBoard, randRow, randCol);
        node.setStyle("-fx-background-color: black");
        shotCoordinates.add(node);
        int columnIndex = GridPane.getColumnIndex(node);
        int rowIndex = GridPane.getRowIndex(node);
        System.out.println("Player 1 shot their shot at " + rows.get(rowIndex) + columns.get(columnIndex));
    }

    public void checkShotCoordinates() {
        List<String> rows = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<Integer> columns = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Shot coordinates: ");
        for (Node node : shotCoordinates) {
            int columnIndex = GridPane.getColumnIndex(node);
            int rowIndex = GridPane.getRowIndex(node);
            System.out.println(rows.get(rowIndex) + columns.get(columnIndex));
        }
    }
}
