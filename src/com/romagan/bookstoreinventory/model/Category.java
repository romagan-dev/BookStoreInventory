package com.romagan.bookstoreinventory.model;

import com.romagan.bookstoreinventory.domain.BaseEntity;

public class Category extends BaseEntity {

    private String name;
    private String description;

    // Порожній конструктор для JSON (Jackson/Gson)
    public Category() {
        super();
    }

    public Category(String name) {
        this();
        // Захист: якщо передали null, запишемо "Без назви"
        this.name = (name != null) ? name : "Без назви";
    }

    public String getName() {
        // Додатковий захист при отриманні
        return name != null ? name : "Без назви";
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
        return getName(); // Використовуємо геттер із захистом
    }
}