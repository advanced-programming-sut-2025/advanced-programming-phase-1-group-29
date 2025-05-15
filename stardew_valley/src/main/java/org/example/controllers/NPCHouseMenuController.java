package org.example.controllers;

import org.example.models.App;
import org.example.models.Objectt;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.VillagePackage.NPCHouse;

import static java.lang.Math.abs;

public class NPCHouseMenuController extends Controller {
    public Result meetNPC(String name){
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof NPCHouse){
                if (abs(((NPCHouse) objectt).getNPCPlaceX() - currentPlayer.getX()) > 1 || abs(((NPCHouse) objectt).getNPCPlaceY() - currentPlayer.getY()) > 1){
                    return new Result(false, "You are too far away");
                }
                if (((NPCHouse) objectt).getName().equalsIgnoreCase(name)){
                    return ((NPCHouse) objectt).meetNPC();
                }
            }
        }
        return new Result(true, "Wrong NPC name");
    }
    public Result questsList(){
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof NPCHouse){
                if (abs(((NPCHouse) objectt).getNPCPlaceX() - currentPlayer.getX()) <= 1 || abs(((NPCHouse) objectt).getNPCPlaceY() - currentPlayer.getY()) <= 1){
                    return ((NPCHouse) objectt).questsList();
                }
            }
        }
        return new Result(false, "you are not close to any of the NPCs");
    }
    public Result questFinish(String indString){
        int ind = Integer.parseInt(indString);
        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof NPCHouse){
                if (abs(((NPCHouse) objectt).getNPCPlaceX() - currentPlayer.getX()) <= 1 || abs(((NPCHouse) objectt).getNPCPlaceY() - currentPlayer.getY()) <= 1){
                    return ((NPCHouse) objectt).questFinish(ind);
                }
            }
        }
        return new Result(false, "you are not close to any of the NPCs");
    }
}
