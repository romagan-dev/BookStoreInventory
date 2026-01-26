package com.romagan.bookstoreinventory.domain.comparator.user;

import com.romagan.bookstoreinventory.model.User;
import java.util.Comparator;

/**
 * Компаратор для сортування користувачів за адресою електронної пошти.
 */
public class UserEmailComparator implements Comparator<User> {

    @Override
    public int compare(User u1, User u2) {
        // Порівнюємо рядки email без урахування регістру (A-Z)
        return u1.getEmail().compareToIgnoreCase(u2.getEmail());
    }
}