package org.example.models;

public class JojaMartStore extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Joja Mart!");
    }
}
