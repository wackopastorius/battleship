package com.example.battleship_sink;
import java.util.Arrays;

    public class Ship {
    private String[] body;
    private String type;

    public Ship(){

    }
    public Ship(String[] body, String type) {
        this.body = Arrays.copyOf(body, body.length);
        this.type = type;
    }
    //getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getBody() {
        return body;
    }

    public void setBody(String[] body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "body=" + Arrays.toString(body) +
                ", type='" + type + '\'' +
                '}';
    }

}
