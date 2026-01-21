package com.romagan.bookstoreinventory.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Базовий клас для всіх сутностей системи. Забезпечує автоматичну генерацію унікального ID та
 * механізм збору помилок валідації.
 */
public abstract class BaseEntity implements Entity {

    private final UUID id;

    // Мапа для зберігання помилок валідації (назва поля -> список повідомлень)
    protected Map<String, List<String>> errors = new HashMap<>();

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

    /**
     * Метод для додавання помилки валідації для конкретного поля.
     */
    protected void addError(String field, String message) {
        errors.computeIfAbsent(field, k -> new ArrayList<>()).add(message);
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}