package com.romagan.bookstoreinventory.domain.comparator.book;

import com.romagan.bookstoreinventory.domain.Book;
import java.util.Comparator;

/**
 * Компаратор для сортування книг за кількістю на складі.
 */
public class BookQuantityComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        // Порівнюємо цілі числа (int quantity)
        // Сортування від найменшої кількості до найбільшої
        return Integer.compare(b1.getQuantity(), b2.getQuantity());
    }
}