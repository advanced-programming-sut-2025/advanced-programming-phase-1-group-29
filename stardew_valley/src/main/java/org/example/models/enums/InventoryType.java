package org.example.models.enums;

public enum InventoryType {
    PRIMARY(12),
    BIG(24),
    DELUXE(Integer.MAX_VALUE);

    private final int capacity;

    InventoryType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
