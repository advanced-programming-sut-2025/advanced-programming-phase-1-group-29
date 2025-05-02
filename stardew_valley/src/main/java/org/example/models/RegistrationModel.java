package org.example.models;

import org.example.models.enums.RegisterState;

public class RegistrationModel {
    private User user = null;
    private RegisterState registerState = RegisterState.NOT_STARTED;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RegisterState getRegisterState() {
        return registerState;
    }

    public void setRegisterState(RegisterState registerState) {
        this.registerState = registerState;
    }
}
