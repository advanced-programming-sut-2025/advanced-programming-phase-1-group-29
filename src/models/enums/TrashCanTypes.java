package models.enums;

public enum TrashCanTypes {
    Basic(0),
    Copper(15),
    Iron(30),
    Gold(45),
    Iridium(60);

    private final int returnValuePercentage;

    TrashCanTypes(int returnValuePercentage) {
        this.returnValuePercentage = returnValuePercentage;
    }
}
