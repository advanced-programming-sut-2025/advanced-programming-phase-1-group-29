package org.example.controllers;

import org.example.models.App;
import org.example.models.RegistrationModel;
import org.example.models.Result;
import org.example.models.User;
import org.example.models.enums.Gender;
import org.example.models.enums.Menu;
import org.example.models.enums.RegisterMenuCommands;
import org.example.models.enums.RegisterState;

public class RegisterMenuController extends Controller{
    private final RegistrationModel registrationModel = new RegistrationModel();

    public Result menuEnter(String menuName) {
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

    public Result register(
            String username, String password, String passwordConfirm, String nickname, String email, String gender
    ) {
        registrationModel.setRegisterState(RegisterState.NOT_STARTED);
        registrationModel.setUser(null);
        if (RegisterMenuCommands.Username.getMatcher(username) == null)
            return new Result(false, "Invalid username format");
        if (App.findUserByUsername(username) != null) {
            // suggest another username
            return new Result(false, "The username is already taken.");
        }
        if (RegisterMenuCommands.Email.getMatcher(email) == null)
            return new Result(false, "Invalid Email Format");
        if (RegisterMenuCommands.Password.getMatcher(password) == null)
            return new Result(false, "Invalid Email Format");
        if (RegisterMenuCommands.StrongPassword.getMatcher(password) == null || password.length() < 8)
            return new Result(false, "The password is too weak");
        if (!password.equals(passwordConfirm))
            return new Result(false, "The password confirmation is wrong.");
        User user = new User(username, password, email, nickname, Gender.getGender(gender));
        registrationModel.setRegisterState(RegisterState.REGISTERED_INFO_VALID);
        registrationModel.setUser(user);
        return new Result(true, printSecurityQuestions());
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
        User user = registrationModel.getUser();
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
