package com.romagan.bookstoreinventory.service.impl;

import com.romagan.bookstoreinventory.domain.exception.EntityValidationException;
import com.romagan.bookstoreinventory.domain.repository.Repository;
import com.romagan.bookstoreinventory.domain.util.EmailValidator;
import com.romagan.bookstoreinventory.domain.util.PasswordHasher;
import com.romagan.bookstoreinventory.domain.util.ValidationError;
import com.romagan.bookstoreinventory.model.User;
import com.romagan.bookstoreinventory.service.EmailService;

public class AuthServiceImpl {

    private final Repository<User> userRepository;
    private final EmailService emailService;
    private User currentUser;

    private User pendingUser;
    private String lastGeneratedCode;
    private long codeCreatedAt;

    public AuthServiceImpl(Repository<User> userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void startRegistration(User user, String password) {
        if (!EmailValidator.isValid(user.getEmail())) {
            throw new EntityValidationException(ValidationError.EMAIL_FORMAT.getMessage());
        }

        boolean exists = userRepository.findAll().stream()
              .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));
        if (exists) {
            throw new EntityValidationException(ValidationError.EMAIL_ALREADY_EXISTS.getMessage());
        }

        // Генеруємо 4-значний код
        this.lastGeneratedCode = String.valueOf((int) ((Math.random() * 9000) + 1000));
        this.codeCreatedAt = System.currentTimeMillis();
        this.pendingUser = user;

        // Хешуємо пароль перед тимчасовим збереженням
        this.pendingUser.setPassword(PasswordHasher.hash(password));

        // Відправляємо код (Debug вивід буде в консолі всередині сервісу)
        emailService.sendVerificationCode(user.getEmail(), lastGeneratedCode);
    }

    public void confirmRegistration(String inputCode) {
        if (pendingUser == null) {
            throw new EntityValidationException(
                  ValidationError.REGISTRATION_SESSION_NOT_FOUND.getMessage());
        }

        // Перевірка терміну дії (5 хвилин)
        if (System.currentTimeMillis() - codeCreatedAt > 300000) {
            pendingUser = null;
            throw new EntityValidationException(ValidationError.OTP_CODE_EXPIRED.getMessage());
        }

        // ПІДТРИМКА DEBUG MODE: пускаємо, якщо введено реальний код АБО 0000
        if (!lastGeneratedCode.equals(inputCode) && !inputCode.equals("0000")) {
            throw new EntityValidationException(ValidationError.INVALID_OTP_CODE.getMessage());
        }

        userRepository.save(pendingUser);
        emailService.sendWelcomeEmail(pendingUser.getEmail());

        pendingUser = null;
        lastGeneratedCode = null;
    }

    public User login(String email, String password) {
        User user = userRepository.findAll().stream()
              .filter(u -> u.getEmail().equalsIgnoreCase(email))
              .findFirst()
              .orElseThrow(() -> new EntityValidationException("Невірний email або пароль!"));

        if (!PasswordHasher.check(password, user.getPassword())) {
            throw new EntityValidationException("Невірний email або пароль!");
        }

        this.currentUser = user;
        return user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}