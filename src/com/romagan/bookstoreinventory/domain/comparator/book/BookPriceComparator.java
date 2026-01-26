package com.romagan.bookstoreinventory.domain.comparator.book;

import com.romagan.bookstoreinventory.model.Book;
import java.util.Comparator;

/**
 * Компаратор для сортування книг за ціною.
 */
public class BookPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        // Використовуємо метод compare для double/BigDecimal
        // Це дозволить сортувати від меншої ціни до більшої
        return Double.compare(b1.getPrice(), b2.getPrice());
    }
}