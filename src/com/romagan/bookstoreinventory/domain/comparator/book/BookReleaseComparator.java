package com.romagan.bookstoreinventory.domain.comparator.book;

import com.romagan.bookstoreinventory.model.Book;
import java.util.Comparator;

/**
 * Компаратор для сортування книг за датою виходу (рік видання).
 */
public class BookReleaseComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        // Порівнюємо роки виходу
        // Сортування від старіших видань до новіших
        return Integer.compare(b1.getReleaseYear(), b2.getReleaseYear());
    }
}