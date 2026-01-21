package com.romagan.bookstoreinventory.domain.comparator.user;

import com.romagan.bookstoreinventory.domain.User;
import java.util.Comparator;

/**
 * Компаратор для сортування користувачів за повним іменем (Ім'я + Прізвище).
 */
public class UserFullNameComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        // Формуємо повні імена для порівняння
        String fullName1 = u1.getFirstName() + " " + u1.getLastName();
        String fullName2 = u2.getFirstName() + " " + u2.getLastName();

        // Порівнюємо за алфавітом без урахування регістру
        return fullName1.compareToIgnoreCase(fullName2);
    }
}