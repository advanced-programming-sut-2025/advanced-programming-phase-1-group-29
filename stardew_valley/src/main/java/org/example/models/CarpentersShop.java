package org.example.models;

public class CarpentersShop extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Carpenter's shop!");
    }
}
