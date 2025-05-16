package org.example.models;

import java.util.ArrayList;

public class Objectt {
    private ArrayList<Tile> tiles = new ArrayList<>();

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public boolean hasTile(int x, int y){
        for (Tile tile : tiles) {
            if(tile.getX() == x && tile.getY() == y){
                return true;
            }
        }
        return false;
    }
}
