package org.example.models.enums;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender getGender(String gender) {
        if (gender.equals("male")) return Gender.MALE;
        return Gender.FEMALE;
    }
}
