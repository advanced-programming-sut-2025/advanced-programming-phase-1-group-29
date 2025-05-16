package org.example.models;

import org.example.models.AppState;

import java.io.*;

public class AppSaver {
    public static void saveAppState(AppState state, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(state);
            System.out.println("Game state saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppState loadAppState(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (AppState) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
