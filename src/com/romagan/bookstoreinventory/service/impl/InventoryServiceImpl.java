package com.romagan.bookstoreinventory.service.impl;

import com.romagan.bookstoreinventory.domain.exception.EntityValidationException;
import com.romagan.bookstoreinventory.model.Book;

/**
 * Реалізація сервісу управління складськими запасами.
 */
public class InventoryServiceImpl {

    /**
     * Оновлює кількість книг на складі.
     */
    public void updateStock(Book book, int newQuantity) {
        if (newQuantity < 0) {
            throw new EntityValidationException("Кількість товару не може бути від’ємною"); //
        }
        book.setQuantity(newQuantity); //
    }

    /**
     * Перевіряє, чи є достатня кількість книг для продажу.
     */
    public boolean isInStock(Book book, int requestedQuantity) {
        return book.getQuantity() >= requestedQuantity; //
    }

    /**
     * Списує певну кількість книг зі складу.
     */
    public void reduceStock(Book book, int amount) {
        if (!isInStock(book, amount)) {
            throw new EntityValidationException("Недостатньо товару на складі: " + book.getTitle());
        }
        book.setQuantity(book.getQuantity() - amount);
    }
}