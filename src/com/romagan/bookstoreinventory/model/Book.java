package com.romagan.bookstoreinventory.model;

// ПРАВИЛЬНИЙ ІМПОРТ: тепер він веде в model, а не в domain

import com.romagan.bookstoreinventory.domain.BaseEntity;

/**
 * Сутність, що представляє книгу в системі обліку.
 */
public class Book extends BaseEntity {

    private String title;
    private Author author;
    // Якщо Category та Publisher теж у model — змінити імпорти або видалити ці поля, якщо вони не використовуються
    private Category category;
    private Publisher publisher;
    private double price;
    private int quantity;
    private int releaseYear;

    public Book() {
        super();
    }

    public Book(String title, Author author, double price, int quantity, int releaseYear) {
        this();
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.releaseYear = releaseYear;
        this.category = new Category();
    }

    // Геттери та сеттери (залишаються без змін)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Category getCategory() {
        return category;
    }

    
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format(
              "«%-20s» | Автор: %-15s | Рік: %d | Ціна: %7.2f грн | (В наявності: %d)",
              title,
              (author != null ? author.getLastName() : "Невідомий"),
              releaseYear, price, quantity
        );
    }
}