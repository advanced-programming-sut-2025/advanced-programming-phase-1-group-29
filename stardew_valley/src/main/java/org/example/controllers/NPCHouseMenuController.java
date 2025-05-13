package org.example.controllers;

import org.example.models.App;
import org.example.models.Objectt;
import org.example.models.Result;
import org.example.models.VillagePackage.NPCHouse;

public class NPCHouseMenuController extends Controller {
    public Result meetNPC(String name){
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof NPCHouse){
                if (((NPCHouse) objectt).getName().equalsIgnoreCase(name)){
                    return ((NPCHouse) objectt).meetNPC();
                }
            }
        }
        return new Result(true, "Wrong NPC name");
    }

}
