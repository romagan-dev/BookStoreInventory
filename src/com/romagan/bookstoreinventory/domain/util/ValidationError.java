package com.romagan.bookstoreinventory.domain.util;

public enum ValidationError {
    // User (залишаємо як у викладача)
    FIRST_NAME_REQUIRED("Ім'я не може бути порожнім."),
    LAST_NAME_REQUIRED("Прізвище не може бути порожнім."),
    PASSWORD_REQUIRED("Пароль не може бути порожнім."),
    EMAIL_FORMAT("Невірний формат електронної пошти."),

    // Category (замість Genre)
    CATEGORY_NAME_REQUIRED("Назва категорії не може бути порожньою."),

    // Book (головний товар магазину)
    BOOK_TITLE_REQUIRED("Назва книги не може бути порожньою."),
    BOOK_ISBN_FORMAT("Невірний формат ISBN-13."),
    BOOK_PRICE_INVALID("Ціна повинна бути більшою за 0."),
    BOOK_QUANTITY_INVALID("Кількість на складі не може бути від'ємною."),
    BOOK_AUTHOR_REQUIRED("Автор є обов'язковим."),

    // Publisher (важливо для постачання)
    PUBLISHER_NAME_REQUIRED("Назва видавництва не може бути порожньою."),

    // Common
    ID_REQUIRED("ID об'єкта є обов'язковим.");

    private final String message;

    ValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}