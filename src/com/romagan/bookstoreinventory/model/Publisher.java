package com.romagan.bookstoreinventory.model;

import com.romagan.bookstoreinventory.domain.BaseEntity;

/**
 * Сутність, що представляє видавництво книг.
 */
public class Publisher extends BaseEntity {

    private String name;
    private String address;
    private String contactNumber;

    public Publisher() {
        super();
    }

    public Publisher(String name) {
        this();
        this.name = name;
    }

    // Геттери та сеттери
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Видавництво: " + name;
    }
}