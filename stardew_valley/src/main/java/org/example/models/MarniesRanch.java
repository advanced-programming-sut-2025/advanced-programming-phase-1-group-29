package org.example.models;

public class MarniesRanch extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Marnies Ranch!");
    }
}
