package org.example.models;

public class Tile {
    private char display;
    private int x;
    private int y;

    public Tile(char display, int x, int y) {
        this.display = display;
        this.x = x;
        this.y = y;
    }

    public char getDisplay() {
        return display;
    }

    public void setDisplay(char display) {
        this.display = display;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
