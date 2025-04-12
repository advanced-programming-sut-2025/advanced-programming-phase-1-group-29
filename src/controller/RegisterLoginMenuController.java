package controller;

import models.Result;
import models.enums.Gender;

public class RegisterLoginMenuController {
    public Result register(String username, String password, String confirmPassword, String nickname, String email, Gender gender) {

    }

    public Result exit(){

    }

    public Result showCurrentMenu(){

    }

    public Result generateRandomPassword(){

    }

    public Result printSecurityQuestions(){}

    public Result pickSecurityQuestion(int questionNumber, String answer, String confirmAnswer){}

    public Result login(String username, String password, Boolean stayLoggedIn){

    }

    public Result forgotPassword(String username, String answer){}
}
