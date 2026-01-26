package com.romagan.bookstoreinventory.model;

import com.romagan.bookstoreinventory.domain.BaseEntity;

/**
 * Сутність, що представляє категорію (жанр) книг.
 */
public class Category extends BaseEntity {

    private String name;
    private String description;

    public Category() {
        super();
    }

    public Category(String name) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}