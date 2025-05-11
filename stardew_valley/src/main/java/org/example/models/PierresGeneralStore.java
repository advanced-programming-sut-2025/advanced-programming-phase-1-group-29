package org.example.models;

public class PierresGeneralStore extends Store{
    @Override
    public Result welcomeMessage() {
        return new Result(true, "Welcome to Pierres General!");
    }
}
