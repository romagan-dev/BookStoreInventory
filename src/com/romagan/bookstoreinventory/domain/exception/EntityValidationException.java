package com.romagan.bookstoreinventory.domain.exception;

/**
 * Виключення, що виникає при помилці валідації сутностей.
 */
public class EntityValidationException extends RuntimeException {

    // Конструктор, який приймає повідомлення про помилку
    public EntityValidationException(String message) {
        super(message);
    }
}