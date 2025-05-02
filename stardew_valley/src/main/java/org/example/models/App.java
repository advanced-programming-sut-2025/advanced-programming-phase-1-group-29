package org.example.models;

import org.example.models.enums.Menu;
import org.example.models.enums.RegisterState;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static Menu currentMenu = Menu.RegisterMenu;
    private final static ArrayList<User> users = new ArrayList<>();
    private static User loggedInUser = null;
    private final static ArrayList<String> securityQuestions = new ArrayList<>(List.of(
            "WHAT IS THE GIVEN NAME OF YOUR MOTHER'S MOTHER?",
            "WHAT IS THE GIVEN NAME OF YOUR FATHER'S FATHER?",
            "WHAT STREET DID YOU LIVE ON WHEN YOU WERE 8 YEARS OLD?",
            "WHAT IS THE NAME OF YOUR FAVORITE CHILDHOOD FRIEND?"
    ));
    private static User userInRegisteringProcess = null;
    private static RegisterState registerState = RegisterState.NOT_STARTED;

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }

    public static User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }

    public static ArrayList<String> getSecurityQuestions() {
        return securityQuestions;
    }

    public static User getUserInRegisteringProcess() {
        return userInRegisteringProcess;
    }

    public static void setUserInRegisteringProcess(User userInRegisteringProcess) {
        App.userInRegisteringProcess = userInRegisteringProcess;
    }

    public static RegisterState getRegisterState() {
        return registerState;
    }

    public static void setRegisterState(RegisterState registerState) {
        App.registerState = registerState;
    }
}
