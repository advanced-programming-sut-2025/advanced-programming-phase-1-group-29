package org.example.models;

import org.example.models.enums.Gender;

public class User {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Gender gender;
    private String securityQuestion;
    private String answerToSecurityQuestion;
    int numberOfGames = 0;
    int maxCoins = 0;


    public User(String username, String password, String nickname, String email, Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswerToSecurityQuestion() {
        return answerToSecurityQuestion;
    }

    public void setAnswerToSecurityQuestion(String answerToSecurityQuestion) {
        this.answerToSecurityQuestion = answerToSecurityQuestion;
    }
}
