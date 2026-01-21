package com.romagan.bookstoreinventory.domain.comparator.author;

import com.romagan.bookstoreinventory.domain.Author;
import java.util.Comparator;

public class AuthorFullNameComparator implements Comparator<Author> {

    @Override
    public int compare(Author a1, Author a2) {
        // Створюємо повні імена для порівняння
        String fullName1 = a1.getFirstName() + " " + a1.getLastName();
        String fullName2 = a2.getFirstName() + " " + a2.getLastName();

        // Використовуємо стандартний метод compareTo для рядків
        return fullName1.compareToIgnoreCase(fullName2);
    }
}