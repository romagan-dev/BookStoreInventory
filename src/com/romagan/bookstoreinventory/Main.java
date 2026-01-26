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

    static void main(String[] args) {
        // Завантаження бази даних
        UnitOfWork uow = new UnitOfWork();
        uow.load();

        // 1. Створюємо сервіси
        EmailService emailService = new EmailServiceImpl();
        AuthServiceImpl authService = new AuthServiceImpl(uow.getUserRepository(), emailService);
        BookServiceImpl bookService = new BookServiceImpl(uow.getBookRepository());

        // 2. Створюємо сторінки з УСІМА необхідними залежностями
        // Для AdminPage тепер потрібні репозиторії авторів та категорій
        AdminPage adminPage = new AdminPage(
              bookService,
              uow.getAuthorRepository(),   // Переконайся, що цей метод є в uow
              uow.getCategoryRepository(), // Переконайся, що цей метод є в uow
              uow
        );

        // Для CustomerPage тепер потрібні authService та orderRepository
        CustomerPage customerPage = new CustomerPage(
              bookService,
              authService,
              uow.getOrderRepository(),    // Переконайся, що цей метод є в uow
              uow
        );

        // 3. Головна сторінка авторизації
        AuthPage authPage = new AuthPage(authService, uow, adminPage, customerPage);

        authPage.display();
    }
}