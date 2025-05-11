package org.example.models;

public class TheStardropSaloon extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to The Stardrop Shop!");
    }
}
