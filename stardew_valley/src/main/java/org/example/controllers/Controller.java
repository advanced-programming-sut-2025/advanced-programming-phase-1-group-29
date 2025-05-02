package org.example.controllers;

import org.example.models.App;
import org.example.models.Result;

public abstract class Controller {
    public Result showCurrentMenu() {
        return new Result(true, App.getCurrentMenu().toString());
    }
}
