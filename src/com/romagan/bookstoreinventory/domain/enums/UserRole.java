package com.romagan.bookstoreinventory.domain.enums;

public enum UserRole {
    USER("користувач"),
    CASHIER("касир"),
    WAREHOUSEMANAGER("главскладу"),
    ADMIN("адміністратор");


    private final Object name;

    UserRole(String name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }
}
