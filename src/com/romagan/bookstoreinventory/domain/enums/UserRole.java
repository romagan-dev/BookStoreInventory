package com.romagan.bookstoreinventory.domain.enums;

public enum UserRole {
    USER("Користувач"),
    CUSTOMER("Покупець"),
    CASHIER("Касир"),
    WAREHOUSE_MANAGER("Завідувач складу"), // Виправлено назву та опис
    ADMIN("Адміністратор");

    private final String displayValue; // Змінено Object на String

    UserRole(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}