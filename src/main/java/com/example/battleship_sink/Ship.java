package com.example.battleship_sink;

/*
* Author: Mikael Petersson
*
*/

import java.util.Arrays;

    public class Ship {
        private int[] body;
        private boolean isDestroyed;


        public Ship() {

        }

        public Ship(int[] body, boolean isDestroyed) {
            this.body = Arrays.copyOf(body, body.length);
            this.isDestroyed = isDestroyed;
        }
        //getters and setters

        public int[] getBody() {
            return body;
        }

        public void setBody(int[] body) {
            this.body = body;
        }

        public boolean isDestroyed() {
            return isDestroyed;
        }

        public void setDestroyed(boolean destroyed) {
            isDestroyed = destroyed;
        }

        public int[] assignBodyArray(int number){
        return null;
        }


        @Override
        public String toString() {
            return "Ship{" +
                    "body=" + Arrays.toString(body);
        }
    }
