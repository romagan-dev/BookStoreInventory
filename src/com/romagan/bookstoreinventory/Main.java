package com.romagan.bookstoreinventory;

import com.romagan.bookstoreinventory.domain.repository.UnitOfWork;
import com.romagan.bookstoreinventory.service.EmailService;
import com.romagan.bookstoreinventory.service.impl.AuthServiceImpl;
import com.romagan.bookstoreinventory.service.impl.BookServiceImpl;
import com.romagan.bookstoreinventory.service.impl.EmailServiceImpl;
import com.romagan.bookstoreinventory.ui.pages.AdminPage;
import com.romagan.bookstoreinventory.ui.pages.AuthPage;
import com.romagan.bookstoreinventory.ui.pages.CustomerPage;

public class Main {

    static void main(String[] args) { // Додав public
        // Завантаження бази даних
        UnitOfWork uow = new UnitOfWork();
        uow.load();

        // 1. Створюємо сервіси
        EmailService emailService = new EmailServiceImpl();
        AuthServiceImpl authService = new AuthServiceImpl(uow.getUserRepository(), emailService);
        BookServiceImpl bookService = new BookServiceImpl(uow.getBookRepository());

        // 2. Створюємо сторінки
        // ТУТ УВАГА: додаємо uow.getOrderRepository() четвертим параметром
        AdminPage adminPage = new AdminPage(
              bookService,
              uow.getAuthorRepository(),
              uow.getCategoryRepository(),
              uow.getOrderRepository(), // ОСЬ ЦЕЙ ПАРАМЕТР МИ ДОДАЛИ
              uow
        );

        CustomerPage customerPage = new CustomerPage(
              bookService,
              authService,
              uow.getOrderRepository(),
              uow
        );

        // 3. Головна сторінка авторизації
        AuthPage authPage = new AuthPage(authService, uow, adminPage, customerPage);

        // Запуск програми
        authPage.display();
    }
}