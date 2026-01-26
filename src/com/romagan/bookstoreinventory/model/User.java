package com.romagan.bookstoreinventory.model;

import com.romagan.bookstoreinventory.domain.BaseEntity;
import com.romagan.bookstoreinventory.domain.enums.UserRole;

/**
 * Сутність користувача (працівника), яка має доступ до системи.
 */
public class User extends BaseEntity implements Comparable<User> {

    private String firstName;
    private String lastName;
    private String password; // У сервісах ми використовували getPassword()
    private String email;
    private String avatarPath;
    private UserRole role;

    public User() {
        super();
    }

    public User(String firstName, String lastName, String email, UserRole role) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
    }

    // Геттери та сеттери (необхідні для компараторів та сервісів)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    @Override
    public int compareTo(User o) {
        if (this.lastName == null || o.lastName == null) {
            return 0;
        }
        return this.lastName.compareToIgnoreCase(o.lastName);
    }

    @Override
    public String toString() {
        // Використовуємо displayValue з вашого Enum UserRole
        String roleName = (role != null) ? role.getDisplayValue() : "без ролі";
        return String.format("%s %s (%s) — %s", firstName, lastName, roleName, email);
    }
}