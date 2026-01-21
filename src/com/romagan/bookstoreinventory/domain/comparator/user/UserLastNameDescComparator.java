package com.romagan.bookstoreinventory.domain.comparator.user;

import com.romagan.bookstoreinventory.domain.User;
import java.util.Comparator;

/**
 * Компаратор для сортування користувачів за прізвищем у зворотному порядку (Z-A).
 */
public class UserLastNameDescComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        // Для зворотного порядку ми порівнюємо u2 з u1 (замість u1 з u2)
        return u2.getLastName().compareToIgnoreCase(u1.getLastName());
    }
}