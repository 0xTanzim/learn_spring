package com.eazybytes.eazyschool.validations;

import java.util.List;

import com.eazybytes.eazyschool.annotation.PasswordValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

    private static final int MIN_LENGTH = 6;
    private List<String> commonPasswords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        // Define a list of common passwords to reject
        commonPasswords = List.of("password", "123456", "qwerty", "abc123", "letmein");
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.trim().isEmpty()) {
            return false; // Null or empty password is invalid
        }

        String trimmedPassword = password.trim();

        return hasMinimumLength(trimmedPassword)
                && !isCommonPassword(trimmedPassword)
                && containsRequiredCharacterTypes(trimmedPassword);
    }

    // Check for minimum password length
    private boolean hasMinimumLength(String password) {
        return password.length() >= MIN_LENGTH;
    }

    // Check if the password is a known weak/common password
    private boolean isCommonPassword(String password) {
        return commonPasswords.contains(password.toLowerCase());
    }

    // Check if password contains at least one digit, one uppercase, one lowercase
    private boolean containsRequiredCharacterTypes(String password) {
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);
        return hasUppercase && hasLowercase;
    }

    // private void setMessage(ConstraintValidatorContext context, String message) {
    //     context.disableDefaultConstraintViolation();
    //     context.buildConstraintViolationWithTemplate(message)
    //             .addConstraintViolation();
    // }
}
