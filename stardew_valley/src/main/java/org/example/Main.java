package org.example;

import org.example.models.App;
import org.example.models.AppSaver;
import org.example.models.AppState;
import org.example.views.AppView;

public class Main {
    public static void main(String[] args) {
        AppState loaded = AppSaver.loadAppState("save.dat");
        if (loaded != null) {
            App.importState(loaded);
        }
        (new AppView()).run();
    }
}