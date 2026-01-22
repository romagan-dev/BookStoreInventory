package com.romagan.bookstoreinventory;

import com.romagan.bookstoreinventory.domain.Author;
import com.romagan.bookstoreinventory.domain.Book;
import com.romagan.bookstoreinventory.domain.impl.BookServiceImpl;
import com.romagan.bookstoreinventory.domain.repository.UnitOfWork;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {
        UnitOfWork uow = new UnitOfWork();
        uow.load(); // 1. ПЕРШИМ ДІЛОМ ЗАВАНТАЖУЄМО СТАРИЙ СКЛАД

        BookServiceImpl bookService = new BookServiceImpl(uow.getBookRepository());
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- СИСТЕМА УПРАВЛІННЯ СКЛАДОМ ---");
            System.out.println("1. Додати новий товар на склад");
            System.out.println("2. Показати весь інвентар");
            System.out.println("3. Пошук товару");
            System.out.println("4. Видалити товар (списання)");
            System.out.println("5. Зберегти стан складу (Commit)");
            System.out.println("0. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // РУЧНЕ ДОДАВАННЯ ТОВАРУ
                    System.out.print("Назва: ");
                    String title = scanner.nextLine();
                    System.out.print("Автор: ");
                    String auth = scanner.nextLine();
                    System.out.print("Ціна: ");
                    double price = scanner.nextDouble();
                    System.out.print("Кількість: ");
                    int qty = scanner.nextInt();
                    bookService.create(new Book(title, new Author(auth, ""), price, qty, 2024));
                    break;
                case 2:
                    bookService.findAll().forEach(System.out::println);
                    break;
                case 5:
                    uow.commit(); // ТЕПЕР ЦЕ ПИШЕ У ФАЙЛ, ЯКИЙ МИ ЗЧИТАЄМО НАСТУПНОГО РАЗУ
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
    }
}