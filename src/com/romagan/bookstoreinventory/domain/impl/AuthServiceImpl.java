package com.romagan.bookstoreinventory.domain.impl;

import com.romagan.bookstoreinventory.domain.User;
import com.romagan.bookstoreinventory.domain.enums.UserRole;
import java.util.ArrayList;
import java.util.List;

/**
 * Реалізація сервісу автентифікації.
 */
public class AuthServiceImpl {

    // Список користувачів (імітація бази даних для початку)
    private final List<User> users = new ArrayList<>();
    private User currentUser;

    /**
     * Логіка входу в систему.
     */
    public boolean login(String email, String password) {
        // Тут буде пошук користувача за email та паролем
        // Якщо знайдено: currentUser = foundUser; return true;
        return false;
    }

    /**
     * Перевірка, чи є поточний користувач адміністратором.
     */
    public boolean isAdmin() {
        return currentUser != null && currentUser.getRole() == UserRole.ADMIN;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}