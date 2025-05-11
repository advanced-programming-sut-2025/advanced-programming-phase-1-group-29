package org.example.models;

public class FishShop extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Fish Shop!");
    }
}
