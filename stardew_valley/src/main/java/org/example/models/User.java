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
    private int numberOfGames = 0;
    private int maxCoins = 0;
    private Game currentGame = null;


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

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Gender getGender() {
        return gender;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getMaxCoins() {
        return maxCoins;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public void setMaxCoins(int maxCoins) {
        this.maxCoins = maxCoins;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
