package com.romagan.bookstoreinventory.domain;

import com.romagan.bookstoreinventory.domain.enums.UserRole;

public class User extends BaseEntity implements Comparable<User> {

    private String firstName;
    private String lastName;
    private String passwordHash;
    private String email;
    private String avatarPath;
    private UserRole role;

    @Override
    public int compareTo(User o) {
        if (this.lastName == null) {
            return -1;
        }

        return this.lastName.compareTo(o.lastName);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", firstName, lastName, role, email);
    }
}
