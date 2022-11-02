module com.example.battleship_sink {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.battleship_sink to javafx.fxml;
    exports com.example.battleship_sink;
}