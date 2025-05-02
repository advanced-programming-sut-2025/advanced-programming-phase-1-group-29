package org.example.models;

import org.example.models.enums.RegisterState;

public class RegistrationModel {
    private String username;
    private String password;
    private String passwordConfirm;
    private String nickname;
    private String email;
    private String gender;
    private RegisterState registerState = RegisterState.NOT_STARTED;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setUser(
            String username, String password, String passwordConfirm, String nickname, String email, String gender
    ) {
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.nickname = nickname;
        this.email = email;
        this.gender = gender;
    }

    public RegisterState getRegisterState() {
        return registerState;
    }

    public void setRegisterState(RegisterState registerState) {
        this.registerState = registerState;
    }
}
