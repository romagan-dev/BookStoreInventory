package com.romagan.bookstoreinventory.domain;

/**
 * Сутність, що представляє книгу в системі обліку.
 */
public class Book extends BaseEntity {

    private String title;
    private Author author;
    private Category category;
    private Publisher publisher;
    private double price;
    private int quantity;
    private int releaseYear;

    // Конструктор за замовчуванням
    public Book() {
        super();
    }

    // Конструктор з основними полями
    public Book(String title, Author author, double price, int quantity, int releaseYear) {
        this();
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
        this.releaseYear = releaseYear;
    }

    // Геттери та сеттери
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
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

    @Override
    public String toString() {
        return "Книга: '" + title + "' | Автор: " + (author != null ? author.getLastName() : "н/д")
              +
              " | Ціна: " + price + " | На складі: " + quantity;
    }
}