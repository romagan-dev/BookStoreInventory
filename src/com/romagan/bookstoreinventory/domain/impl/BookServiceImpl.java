package com.romagan.bookstoreinventory.domain.impl;

import com.romagan.bookstoreinventory.domain.Book;
import com.romagan.bookstoreinventory.domain.comparator.book.BookPriceComparator;
import com.romagan.bookstoreinventory.domain.comparator.book.BookQuantityComparator;
import java.util.ArrayList;
import java.util.List;

/**
 * Реалізація сервісу для управління книгами.
 */
public class BookServiceImpl {

    private final List<Book> books = new ArrayList<>();

    /**
     * Додає нову книгу до каталогу.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Повертає список всіх книг.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Сортує книги за ціною, використовуючи ваш компаратор.
     */
    public void sortByPrice() {
        books.sort(new BookPriceComparator()); //
    }

    /**
     * Сортує книги за кількістю на складі.
     */
    public void sortByQuantity() {
        books.sort(new BookQuantityComparator()); //
    }

    /**
     * Пошук книги за назвою.
     */
    public Book findByTitle(String title) {
        return books.stream()
              .filter(b -> b.getTitle().equalsIgnoreCase(title))
              .findFirst()
              .orElse(null);
    }
}