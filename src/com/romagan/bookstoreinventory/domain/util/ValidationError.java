package com.romagan.bookstoreinventory.domain.util;

public enum ValidationError {
    // User
    FIRST_NAME_REQUIRED("Ім'я не може бути порожнім."),
    LAST_NAME_REQUIRED("Прізвище не може бути порожнім."),
    PASSWORD_REQUIRED("Пароль не може бути порожнім."),
    EMAIL_FORMAT("Невірний формат електронної пошти."),
    EMAIL_ALREADY_EXISTS("Користувач з таким email вже існує."),

    // Auth & Email
    INVALID_OTP_CODE("Невірний код підтвердження."),
    OTP_CODE_EXPIRED("Час дії коду вичерпано (5 хв)."),
    REGISTRATION_SESSION_NOT_FOUND("Немає активної сесії реєстрації."),
    INVALID_PROMO_CODE("Невірний секретний код адміна."),

    // Category
    CATEGORY_NAME_REQUIRED("Назва категорії не може бути порожньою."),

    // Book
    BOOK_TITLE_REQUIRED("Назва книги не може бути порожньою."),
    BOOK_ISBN_FORMAT("Невірний формат ISBN-13."),
    BOOK_PRICE_INVALID("Ціна повинна бути більшою за 0."),
    BOOK_QUANTITY_INVALID("Кількість на складі не може бути від'ємною."),
    BOOK_AUTHOR_REQUIRED("Автор є обов'язковим."),

    // Купівля (Додай ці)
    BOOK_OUT_OF_STOCK("Цієї книги немає в наявності!"),
    INSUFFICIENT_STOCK("Недостатньо товару на складі!"),
    INVALID_QUANTITY("Кількість має бути більшою за 0!"),
    INVALID_SELECTION("Невірний вибір! Введіть коректний номер."),
    EMPTY_INVENTORY("На жаль, склад порожній."),
    NUMERIC_VALUE_REQUIRED("Помилка: введіть числове значення!"),

    // Publisher
    PUBLISHER_NAME_REQUIRED("Назва видавництва не може бути порожньою."),

    // Common
    ID_REQUIRED("ID об'єкта є обов'язковим.");

    private final String message;

    // Конструктор має бути ОДИН
    ValidationError(String message) {
        this.message = message;
    }

    // Геттер має бути ОДИН
    public String getMessage() {
        return message;
    }
}