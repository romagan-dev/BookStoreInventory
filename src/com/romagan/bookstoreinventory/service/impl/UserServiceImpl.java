package com.romagan.bookstoreinventory.service.impl;

import com.romagan.bookstoreinventory.domain.comparator.user.UserEmailComparator;
import com.romagan.bookstoreinventory.domain.comparator.user.UserFullNameComparator;
import com.romagan.bookstoreinventory.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Реалізація сервісу для управління користувачами (персоналом).
 */
public class UserServiceImpl {

    private final List<User> users = new ArrayList<>();

    /**
     * Додає нового працівника до системи.
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Повертає всіх користувачів, відсортованих за повним іменем.
     */
    public List<User> getAllUsersSortedByName() {
        List<User> sortedUsers = new ArrayList<>(users);
        sortedUsers.sort(new UserFullNameComparator()); //
        return sortedUsers;
    }

    /**
     * Повертає всіх користувачів, відсортованих за email.
     */
    public List<User> getAllUsersSortedByEmail() {
        List<User> sortedUsers = new ArrayList<>(users);
        sortedUsers.sort(new UserEmailComparator()); //
        return sortedUsers;
    }

    /**
     * Пошук користувача за email.
     */
    public User findByEmail(String email) {
        return users.stream()
              .filter(u -> u.getEmail().equalsIgnoreCase(email))
              .findFirst()
              .orElse(null);
    }
}