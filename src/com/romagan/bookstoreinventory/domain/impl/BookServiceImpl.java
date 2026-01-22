package com.romagan.bookstoreinventory.domain.impl;

import com.romagan.bookstoreinventory.domain.Book;
import com.romagan.bookstoreinventory.domain.comparator.book.BookPriceComparator;
import com.romagan.bookstoreinventory.domain.exception.EntityValidationException;
import com.romagan.bookstoreinventory.domain.repository.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookServiceImpl {

    // Використовуємо інтерфейс репозиторію для доступу до даних
    private final Repository<Book> bookRepository;

    // ВИПРАВЛЕНО: Конструктор тепер приймає репозиторій ззовні (Dependency Injection)
    public BookServiceImpl(Repository<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    // --- CRUD: CREATE ---
    public void create(Book book) {
        if (book == null) {
            throw new EntityValidationException("Книга не може бути порожньою");
        }
        // Зберігаємо книгу в Identity Map через репозиторій
        bookRepository.save(book);
    }

    // --- CRUD: READ ---
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(UUID id) {
        return bookRepository.findById(id);
    }

    // --- ПОШУК ТА ФІЛЬТРАЦІЯ ---

    // Пошук за назвою (частковий збіг, ігноруючи регістр)
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByCondition(book ->
              book.getTitle().toLowerCase().contains(title.toLowerCase()));
    }

    // Фільтрація за ціновим діапазоном
    public List<Book> filterByPriceRange(double min, double max) {
        return bookRepository.findByCondition(book ->
              book.getPrice() >= min && book.getPrice() <= max);
    }

    // --- CRUD: UPDATE ---
    public void update(UUID id, Book updatedBook) {
        // Перевіряємо, чи існує книга
        Book existingBook = bookRepository.findById(id)
              .orElseThrow(() -> new EntityValidationException("Книгу з таким ID не знайдено"));

        // Оновлюємо поля
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setQuantity(updatedBook.getQuantity());
        existingBook.setAuthor(updatedBook.getAuthor());

        // Зберігаємо оновлений об'єкт назад у репозиторій
        bookRepository.save(existingBook);
    }

    // --- CRUD: DELETE ---
    public void delete(UUID id) {
        bookRepository.findById(id)
              .orElseThrow(() -> new EntityValidationException(
                    "Неможливо видалити: товар з ID " + id + " не знайдено на складі!"));
        bookRepository.delete(id);
        System.out.println("товару більше нема з нами:(");
    }

    // --- СОРТУВАННЯ ---

    // Повертає новий відсортований список, не змінюючи оригінал у репозиторії
    public List<Book> getSortedByPrice() {
        List<Book> books = findAll();
        books.sort(new BookPriceComparator());
        return books;
    }

    // Сортує книги безпосередньо (якщо потрібно змінити стан)
    public void sortByPrice() {
        List<Book> books = bookRepository.findAll();
        books.sort(new BookPriceComparator());
        // Оскільки ми працюємо з Identity Map, сортування спискуfindAll()
        // часто достатньо для відображення змін.
    }
}