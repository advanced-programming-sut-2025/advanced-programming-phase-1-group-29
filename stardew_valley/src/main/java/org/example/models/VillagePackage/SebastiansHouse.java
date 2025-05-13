package org.example.models.VillagePackage;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;

import static java.lang.Math.abs;

public class SebastiansHouse extends NPCHouse{

    @Override
    public Result meetNPC() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (abs(super.getNPCPlaceX() - player.getX()) <= 1 )
    }
}
