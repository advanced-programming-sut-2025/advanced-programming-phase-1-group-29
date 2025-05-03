package org.example.controllers;

import org.example.models.App;
import org.example.models.RegistrationModel;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Gender;
import org.example.models.enums.Menu;
import org.example.models.enums.RegisterMenuCommands;
import org.example.models.enums.RegisterState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegisterMenuController extends Controller{
    private final RegistrationModel registrationModel = new RegistrationModel();

    public Result menuEnter(String menuName) {
        registrationModel.setRegisterState(RegisterState.NOT_STARTED);
        registrationModel.setUser(
                null, null, null, null, null, null
        );
        if (!menuName.equals("Login Menu")) return new Result(false, "Invalid menu");
        App.setCurrentMenu(Menu.LoginMenu);
        return new Result(true, "Now you are in Login Menu.");
    }

    private String printSecurityQuestions() {
        StringBuilder result = new StringBuilder("Please pick a security question.\n");
        for (int i = 0; i < App.getSecurityQuestions().size(); i++) {
            result.append(i+1);
            result.append(". ");
            result.append(App.getSecurityQuestions().get(i));
            result.append("\n");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private String generateUsername(String username) {
        ArrayList<Character> characters = new ArrayList<>(List.of('-'));
        for (int i = 0 ; i < 10; i++) {
            characters.add((char) ('0' + i));
        }
        while (true) {
            int randomNumber = (new Random()).nextInt(11);
            char character = characters.get(randomNumber);
            int randomIndex = (new Random()).nextInt(username.length() + 1);
            char[] newUsernameCharArray = new char[username.length() + 1];
            username.getChars(0, randomIndex, newUsernameCharArray, 0);
            newUsernameCharArray[randomIndex] = character;
            username.getChars(randomIndex, username.length(), newUsernameCharArray, randomIndex + 1);
            username = String.valueOf(newUsernameCharArray);
            if (App.findUserByUsername(username) == null) return username;
        }
    }

    private String generateRandomPassword() {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 33 ; i <= 125; i++) {
            if (i == 45 || i == 46 || i == 64 || i == 95 || i == 96) continue;
            characters.add((char) (i));
        }
        int length = 8 + (new Random()).nextInt(5);
        StringBuilder password = new StringBuilder();
        boolean flagSmallLetter = false;
        boolean flagCapitalLetter = false;
        boolean flagNumber = false;
        boolean flagSpecialCharacter = false;
        for (int i = 0; i < length; i++) {
            char character;
            password.append((character = characters.get((new Random()).nextInt(78))));
            if ('0' <= character && character <= '9') flagNumber = true;
            else if ('a' <= character && character <= 'z') flagSmallLetter = true;
            else if ('A' <= character && character <= 'Z') flagCapitalLetter = true;
            else flagSpecialCharacter = true;
        }
        if (!flagNumber) password.append('0' + (new Random()).nextInt(10));
        if (!flagSmallLetter) password.append('a' + (new Random()).nextInt(26));
        if (!flagCapitalLetter) password.append('A' + (new Random()).nextInt(26));
        if (!flagSpecialCharacter) password.append('!' + (new Random()).nextInt(12));
        return password.toString();
    }

    public Result register(
            String username, String password, String passwordConfirm, String nickname, String email, String gender
    ) {
        registrationModel.setRegisterState(RegisterState.NOT_STARTED);
        registrationModel.setUser(
                null, null, null, null, null, null
        );
        if (RegisterMenuCommands.Username.getMatcher(username) == null)
            return new Result(false, "Invalid username format");
        if (App.findUserByUsername(username) != null) {
            registrationModel.setRegisterState(RegisterState.USERNAME_SUGGESTED);
            String newUsername = generateUsername(username);
            registrationModel.setUser(newUsername, password, passwordConfirm, nickname, email, gender);
            return new Result(
                    false,
                    "The username is already taken.\n" + newUsername +
                            " is an alternative. Do you want to choose this as your username?(Y/N)"
            );
        }
        if (RegisterMenuCommands.Email.getMatcher(email) == null)
            return new Result(false, "Invalid Email Format");
        if (password.equals("random")) {
            String randomPassword = generateRandomPassword();
            registrationModel.setRegisterState(RegisterState.RANDOM_PASSWORD);
            registrationModel.setUser(username, randomPassword, randomPassword, nickname, email, gender);
            return new Result(
                    true,
                    "Random password : " + randomPassword +
                            "\nIf you want to select this password enter 'Yes'." +
                            "\nIf you want another random password enter 'Again'"
            );
        }
        else {
            if (RegisterMenuCommands.Password.getMatcher(password) == null)
                return new Result(false, "Invalid Email Format");
            if (RegisterMenuCommands.StrongPassword.getMatcher(password) == null || password.length() < 8)
                return new Result(false, "The password is too weak");
            if (!password.equals(passwordConfirm)) {
                registrationModel.setRegisterState(RegisterState.PASSWORD_CONFIRMATION);
                registrationModel.setUser(username, password, passwordConfirm, nickname, email, gender);
                return new Result(
                        false,
                        "The password confirmation is wrong. Please enter your password again."
                );
            }
        }
        registrationModel.setRegisterState(RegisterState.REGISTERED_INFO_VALID);
        registrationModel.setUser(username, password, passwordConfirm, nickname, email, gender);
        return new Result(true, printSecurityQuestions());
    }

    public Result selectSuggestedUsername(String input) {
        if (!registrationModel.getRegisterState().equals(RegisterState.USERNAME_SUGGESTED))
            return new Result(false, "Invalid command");
        if (input.equals("N")) {
            registrationModel.setRegisterState(RegisterState.NOT_STARTED);
            registrationModel.setUser(
                    null, null, null, null, null, null
            );
            return new Result(true, "Alright. You can register with another username.");
        }
        return register(
                registrationModel.getUsername(), registrationModel.getPassword(),
                registrationModel.getPasswordConfirm(), registrationModel.getNickname(),
                registrationModel.getEmail(), registrationModel.getGender()
        );
    }

    public Result passwordConfirmation(String password) {
        if (!registrationModel.getRegisterState().equals(RegisterState.PASSWORD_CONFIRMATION))
            return new Result(false, "Invalid command");
        return register(
                registrationModel.getUsername(), registrationModel.getPassword(),
                password, registrationModel.getNickname(),
                registrationModel.getEmail(), registrationModel.getGender()
        );
    }

    public Result selectRandomPassword(String input) {
        if (!registrationModel.getRegisterState().equals(RegisterState.RANDOM_PASSWORD))
            return new Result(false, "Invalid command");
        String password, passwordConfirm;
        if (input.equals("Again")) {
            password = "random";
            passwordConfirm = "";
        }
        else {
            password = registrationModel.getPassword();
            passwordConfirm = registrationModel.getPasswordConfirm();
        }
        return register(
                registrationModel.getUsername(), password,
                passwordConfirm, registrationModel.getNickname(),
                registrationModel.getEmail(), registrationModel.getGender()
        );

    }

    public Result pickQuestion(String questionNumberInString, String answer, String answerConfirm) {
        if (!registrationModel.getRegisterState().equals(RegisterState.REGISTERED_INFO_VALID))
            return new Result(false, "Invalid command");
        int questionNumber = Integer.parseInt(questionNumberInString);
        if (questionNumber > App.getSecurityQuestions().size())
            return new Result(false, "Invalid Question Number.\n" + printSecurityQuestions());
        if (!answer.equals(answerConfirm))
            return new Result(
                    false,
                    "The answer confirmation is wrong. Try again.\n" + printSecurityQuestions()
            );
        User user = new User(
                registrationModel.getUsername(), registrationModel.getPassword(), registrationModel.getNickname(),
                registrationModel.getEmail(), Gender.getGender(registrationModel.getGender())
        );
        user.setSecurityQuestion(App.getSecurityQuestions().get(questionNumber - 1));
        user.setAnswerToSecurityQuestion(answer);
        App.addUser(user);
        registrationModel.setRegisterState(RegisterState.SECURITY_QUESTION_PICKED);
        return new Result(true, "You registered successfully.");
    }

    public void menuExit() {
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
