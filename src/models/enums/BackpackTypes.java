package models.enums;

public enum BackpackTypes {
    Basic(12),
    Huge(24),
    Deluxe(Integer.MAX_VALUE);

    private final int capacity;

    BackpackTypes(int capacity) {
        this.capacity = capacity;
    }
}
