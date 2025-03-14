package com.airsofka.admin.domain.admin.utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValueValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+]).{8,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static void validateNotNull(Object value, String fieldName) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
    }

    public static void validateNonNegative(Double value, String fieldName) {
        if (value != null && Double.compare(value, 0.0) < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
    }

    public static void validateStringNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty or null");
        }
    }

    public static void validateListNotEmpty(List<?> value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty or null");
        }
    }

    public static void validateStringNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank");
        }
    }

    public static void validateSpecialCharacters(String value, String fieldName) {
        if (!value.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException(fieldName + " must contain only letters and spaces");
        }
    }

    public static void validateDateNotNull(LocalDateTime value, String fieldName) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }
    }

    public static void validateDateNotEmpty(LocalDateTime value, String fieldName) {
        if (Objects.isNull(value) || value.equals(LocalDateTime.MIN)) {
            throw new IllegalArgumentException(fieldName + " cannot be empty or default");
        }
    }

    public static void validateEmailFormat(String email, String fieldName) {
        if (Objects.isNull(email) || email.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException(fieldName + " has an invalid format");
        }
    }

    public static void validatePasswordFormat(String password, String fieldName) {
        if (Objects.isNull(password) || password.isBlank()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException(fieldName + " must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, one number, and one special character (!@#$%^&*()-+)");
        }
    }
}
