package org.example.models;

import org.example.models.AnimalsPackage.Animal;
import org.example.models.AnimalsPackage.AnimalHouse;
import org.example.models.FarmPackage.Farm;
import org.example.models.FarmPackage.Quarry;
import org.example.models.VillagePackage.NPCHouse;
import org.example.models.VillagePackage.Store;
import org.example.models.enums.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class DateTime {
    private Season season;
    private int day;
    private int time;
    private int year;

    public DateTime(Season season, int day, int time, int year) {
        this.season = season;
        this.day = day;
        this.time = time;
        this.year = year;
    }

    public void incrementTime() {
        time++;
        if (time == 22) {
            time = 9;
            incrementDay();
        }
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                ((Store) objectt).openStore();
            }
        }
    }

    private void putForagingSeed(Farm farm, int i, int j) {
        Object remove = null;
        for (Objectt object : farm.getObjects()) {
            if (object instanceof Furrow) {
                if (
                        object.getTiles().getFirst().getX() == i &&
                                object.getTiles().getFirst().getY() == j
                ) {
                    int seedNumber = (new Random()).nextInt(CropSeedEnum.values().length);
                    CropSeedEnum seedEnum = CropSeedEnum.values()[seedNumber];
                    if (seedEnum.getSeasons().contains(season.toString())) {
                        remove = object;
                        if (seedEnum.equals(CropSeedEnum.MIXEDSEED)) {
                            seedNumber = (new Random()).nextInt(
                                    season.getMixedSeedPossibleCrops().size()
                            );
                            seedEnum = season.getMixedSeedPossibleCrops().get(seedNumber).getSource();
                        }
                        Seed seed = new Seed(seedEnum.getName(), 0);
                        Crop crop = new Crop(seed);
                        crop.setTiles(new ArrayList<Tile>(List.of(new Tile('p', i, j))));
                        farm.getObjects().add(crop);
                        farm.incrementNumOfForaging();
                        crop.setForaging(true);
                    }
                }
            }
        }
        if (remove != null) farm.getObjects().remove(remove);
    }

    private void putForagingCrop(Farm farm, int i, int j) {
        for (Objectt farmObject : farm.getObjects()) {
            for (Tile tile : farmObject.getTiles()) {
                if (tile.getX() == i && tile.getY() == j) {
                    return;
                }
            }
        }
        int cropNumber = (new Random()).nextInt(ForagingCrop.values().length);
        ForagingCrop foragingCrop = ForagingCrop.values()[cropNumber];
        if (foragingCrop.getSeasons().contains(season.toString())) {
            Crop crop = new Crop(ForagingCrop.values()[cropNumber]);
            crop.setTiles(new ArrayList<Tile>(List.of(new Tile('p', i, j))));
            farm.getObjects().add(crop);
            farm.incrementNumOfForaging();
            crop.setForaging(true);
        }
    }

    public void incrementDay() {
        for (Player player : App.getCurrentGame().players) {
            //TODO walk to home
        }
        day++;
        if (day == 29) {
            day = 1;
            if (season.equals(Season.Spring)) setSeason(Season.Summer);
            else if (season.equals(Season.Summer)) setSeason(Season.Fall);
            else if (season.equals(Season.Fall)) setSeason(Season.Winter);
            else setSeason(Season.Spring);
            if (season.equals(Season.Spring)) year++;
        }
        if (App.getCurrentGame().getCheatWeather() != null) {
            App.getCurrentGame().setWeather(App.getCurrentGame().getCheatWeather());
            App.getCurrentGame().setCheatWeather(null);
        }
        else {
            changeWeather();
        }
        for (Objectt objectt : App.getCurrentGame().getMap().getVillage().getObjects()) {
            if (objectt instanceof Store){
                ((Store) objectt).resetCapacity();
            }
            else if (objectt instanceof NPCHouse){
                ((NPCHouse) objectt).setMeetNPCToday(false);
                ((NPCHouse) objectt).setGiftNPCToday(false);
            }
        }
        for (Player player : App.getCurrentGame().getPlayers()){
            player.addRejectedDays();
        }
        resetAttackByCrows();
        attackOfCrows();
        thunder();
        removePlantsOutOfSeason();
        plantGrowth();
        putForaging();
        putForagingMineral();
        setEnergy();
        animalSettings();
        clearShippingBins();
    }

    private void clearShippingBins() {
        for (int i = 0; i < App.getCurrentGame().getMap().getFarms().size(); i++) {
            for (Objectt object : App.getCurrentGame().getMap().getFarms().get(i).getObjects()) {
                if (object instanceof ShippingBin) {
                    clearBin((ShippingBin) object, i);
                    break;
                }
            }
        }
    }

    private void clearBin(ShippingBin bin, int playerNumber) {
        for (InventoryItem item : bin.getItems()) {
            int price = item.getPrice();
            double quality = item.getQuality();
            if (quality > 0.9) price *= 2;
            else if (quality > 0.7) price = (int)(price * 1.5);
            else if (quality > 0.5) price = (int)(price * 1.25);
            App.getCurrentGame().players.get(playerNumber).addCoins(price);
        }
        bin.getItems().clear();
    }

    private void animalSettings() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Farm farm : App.getCurrentGame().getMap().getFarms()){
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Animal animal){
                    animals.add(animal);
                }
            }
            for (Objectt objectt : farm.getObjects()) {
                if (objectt instanceof AnimalHouse animalHouse){
                    for (Animal animal : animalHouse.getAnimals()) {
                        animals.add(animal);
                    }
                }
            }
        }
        for (Animal animal : animals){
            if(animal.isFed()) {
                animal.addProduct();
            }
            animal.setIsFed(false);
            animal.setIsPetted(false);
        }
    }

    private void resetAttackByCrows() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (Objectt object : farm.getObjects()) {
                if (object instanceof FruitTree tree) tree.setAttackedByCrows(false);
            }
        }
    }

    private void attackOfCrows() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Plant> plants = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant) plants.add((Plant) object);
            }
            for (int i = 0; i < plants.size() / 16; i++) {
                int random = (new Random()).nextInt(4);
                if (random == 0) {
                    random = (new Random()).nextInt(16);
                    int index = i * 16 + random;
                    Plant plant = plants.get(index);
                    if (plant instanceof Crop) farm.getObjects().remove(plant);
                    else if (plant instanceof FruitTree tree) tree.setAttackedByCrows(true);
                }
            }
        }
    }

    private void changeWeather() {
        int random = (new Random()).nextInt(season.getWeathers().size());
        App.getCurrentGame().setWeather(season.getWeathers().get(random));
    }

    private void thunder() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Plant> plants = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant) plants.add((Plant) object);
            }
            int random = (new Random()).nextInt(3);
            HashSet<Plant> thundered = new HashSet<>();
            for (int i = 0; i < random; i++) {
                if (plants.isEmpty()) continue;
                int index = (new Random()).nextInt(plants.size());
                thundered.add(plants.get(index));
            }
            for (Plant plant : thundered) {
                farm.getObjects().remove(plant);
                if (plant instanceof FruitTree) {
                    BurnedTree burnedTree = new BurnedTree();
                    burnedTree.setTiles(plant.getTiles());
                    burnedTree.getTiles().get(0).setDisplay('b');
                    farm.getObjects().add(new BurnedTree());
                }
            }
        }
    }

    private void setEnergy() {
        for (Player player : App.getCurrentGame().players) {
            player.setEnergy(200);
            if (player.isCollapsed()) {
                player.setEnergy(150);
                if (player.getRejected()) {
                    player.setEnergy(player.getEnergy()/2);
                }
                player.setCollapsed(false);
            }
        }
    }

    private void putForagingMineral() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            Quarry quarry = null;
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Quarry) {
                    quarry = (Quarry) object;
                    break;
                }
            }
            if (quarry != null) {
                for (Tile tile : quarry.getTiles()) {
                    int random = (new Random()).nextInt(50);
                    if (random == 0 && farm.getNumOfForagingMineral() < 2) {
                        boolean flag = true;
                        for (Foraging mineral : quarry.getMinerals()) {
                            if (mineral.getTiles().getFirst().getX() == tile.getX() && mineral.getTiles().getFirst().getY() == tile.getY()) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            int randomMineral = (new Random()).nextInt(ForagingMineral.values().length);
                            Foraging mineral = new Foraging(ForagingMineral.values()[randomMineral]);
                            mineral.setTiles(new ArrayList<>(List.of(new Tile('m',tile.getX(), tile.getY()))));
                            quarry.addMineral(mineral);
                            farm.incrementNumOfForagingMineral();
                        }
                    }
                }
            }
        }
    }

    private void plantGrowth() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Objectt> toBeRemoved = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Plant plant) {
                    if ((!plant.isWateredEveryDay()) && (!plant.isWateredToday()) && (!plant.isWateredYesterday())) {
                        toBeRemoved.add(object);
                    }
                    else {
                        if (!plant.isReadyForHarvest() && (plant.isWateredToday() || plant.isWateredEveryDay())) {
                            if ((!(plant instanceof FruitTree)) || (!(((FruitTree) plant).isAttackedByCrows()))) {
                                if (!plant.isInHarvestCycle()) plant.grow();
                                else plant.growInCycle();
                            }
                        }
                        plant.setWateredYesterday(plant.isWateredToday());
                        plant.setWateredToday(false);
                        if (App.getCurrentGame().getWeather().equals(Weather.RAINY) || App.getCurrentGame().getWeather().equals(Weather.STORMY)) {
                            plant.setWateredToday(true);
                        }
                    }
                }
            }
            for (Objectt object : toBeRemoved) {
                farm.getObjects().remove(object);
            }
        }
    }

    private void putForaging() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            for (int i = farm.getXStart(); i < farm.getXStart() + Farm.getXRange(); i++) {
                for (int j = farm.getYStart(); j < farm.getYStart() + Farm.getYRange(); j++) {
                    int randomNumber = (new Random()).nextInt(100);
                    if (randomNumber == 0) {
                        if (farm.getNumOfForaging() < 5) {
                            int model = (new Random()).nextInt(2);
                            if (model == 0) { //foraging seed
                                putForagingSeed(farm, i, j);
                            }
                            else { //foraging crop
                                putForagingCrop(farm, i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    private void removePlantsOutOfSeason() {
        for (Farm farm : App.getCurrentGame().getMap().getFarms()) {
            ArrayList<Objectt> toBeRemoved = new ArrayList<>();
            for (Objectt object : farm.getObjects()) {
                if (object instanceof Crop crop) {
                    if (crop.isForaging()) {
                        if (!crop.getForagingCrop().getSeasons().contains(season.toString())) {
                            toBeRemoved.add(crop);
                            farm.decrementNumOfForaging();
                        }
                    }
                    else {
                        if (!crop.getCrop().getSeasons().contains(season.toString())) {
                            toBeRemoved.add(crop);
                        }
                    }
                }
                else if (object instanceof FruitTree) {
                    //TODO
                }
            }
            for (Objectt object : toBeRemoved) {
                farm.getObjects().remove(object);
            }
        }
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }
}
