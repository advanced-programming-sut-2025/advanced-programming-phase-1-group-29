package org.example.models;

import org.example.models.enums.Gender;

public class User {
    private String username;
    private String password;
    private String email;
    private String nickname;
    private Gender gender;

    public User(String username, String password, String email, String nickname, Gender gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }
}
