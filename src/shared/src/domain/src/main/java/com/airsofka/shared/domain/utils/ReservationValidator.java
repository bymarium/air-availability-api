package com.airsofka.shared.domain.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Set;
import java.util.Locale;

public class ReservationValidator {

  public static void validateNotNull(Object value, String fieldName) {
    if (value == null) {
      throw new IllegalArgumentException(fieldName + " can't be null");
    }
  }

  public static void validatePositive(Integer value, String fieldName) {
    if (value == null || value < 0) {
      throw new IllegalArgumentException(fieldName + " must be a positive number");
    }
  }

  public static void validateNotBlank(String value, String fieldName) {
    if (value.isBlank()) {
      throw new IllegalArgumentException(fieldName + " can't be blank");
    }
  }

  public static void validateAlphanumericCharacters(String value, String fieldName) {
    if (!value.matches("^[a-zA-Z0-9\\s]*$")) {
      throw new IllegalArgumentException(fieldName + " can only contain alphanumeric characters spaces");
    }
  }

  public static void validateName(String value, String fieldName) {
    if (!value.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$")) {
      throw new IllegalArgumentException(fieldName + " can only contain letters and spaces.");
    }
  }

  public static void validateEmail(String value, String fieldName) {
    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    if (value == null || !value.matches(emailRegex)) {
      throw new IllegalArgumentException(fieldName + " must be a valid email address.");
    }
  }

  public static void validateCardNumber(String value, String fieldName) {
    if (!value.matches("^\\d{16}$")) {
      throw new IllegalArgumentException(fieldName + " must be exactly 16 digits and contain only numbers.");
    }
  }

  public static void validateIntegerInRange(Integer value, int min, int max, String fieldName) {
    if (value == null || value < min || value > max) {
      throw new IllegalArgumentException(fieldName + " must be between " + min + " and " + max);
    }
  }

  public static void validateExpirationDate(String value, String fieldName) {
    if (!value.matches("^(0[1-9]|1[0-2])/\\d{4}$")) {
      throw new IllegalArgumentException(fieldName + " must be in MM/YYYY format with a valid month.");
    }
    try {
      String[] parts = value.split("/");
      int month = Integer.parseInt(parts[0]);
      int year = Integer.parseInt(parts[1]);

      YearMonth currentYearMonth = YearMonth.now();
      YearMonth cardYearMonth = YearMonth.of(year, month);

      if (cardYearMonth.isBefore(currentYearMonth)) {
        throw new IllegalArgumentException(fieldName + " must not be expired.");
      }
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(fieldName + " has an invalid format.");
    }
  }

  public static void validateMoney(Double value, String fieldName) {
    if (value == null || value < 0) {
      throw new IllegalArgumentException(fieldName + " must be a positive amount.");
    }

    if (!hasTwoDecimalPlaces(value)) {
      throw new IllegalArgumentException(fieldName + " must have at most two decimal places.");
    }
  }

  private static boolean hasTwoDecimalPlaces(Double value) {
    // Usar Locale.US para garantizar el punto como separador decimal
    String textValue = String.format(Locale.US, "%.2f", value);
    double roundedValue = Double.parseDouble(textValue);
    return value.equals(roundedValue);
  }

  public static void validatePaymentMethod(String value, String fieldName) {
    if (value == null || (!value.equals("CARD") && !value.equals("PSE"))) {
      throw new IllegalArgumentException(fieldName + " must be either 'CARD' or 'PSE'.");
    }
  }

  public static void validatePassengerType(String value, String fieldName) {
    Set<String> validPassengerTypes = Set.of("ADULT", "CHILD", "INFANT");

    if (value == null || !validPassengerTypes.contains(value)) {
      throw new IllegalArgumentException(fieldName + " must be one of: 'ADULTS', 'CHILDREN', or 'INFANTS'.");
    }
  }

  public static void validateColombianDocument(String value, String fieldName) {
    if (value == null || !value.matches("^\\d{6,11}$")) {
      throw new IllegalArgumentException(fieldName + " must be a numeric string between 6 and 11 digits.");
    }
  }

  public static void validateBirthdayDate(LocalDate value, String fieldName) {

    if (value.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException(fieldName + " cannot be a future date.");
    }

    if (value.isBefore(LocalDate.of(1900, 1, 1))) {
      throw new IllegalArgumentException(fieldName + " must be after 1900.");
    }
  }

  public static void validateState(String value, String fieldName) {
    if (value == null || (!value.equals("PENDING") && !value.equals("CONFIRMED") && !value.equals("CANCELLED"))) {
      throw new IllegalArgumentException(fieldName + " must be either 'CARD' or 'PSE'.");
    }
  }

  public static void validateListNotEmpty(List<?> list, String fieldName) {
    if (list == null || list.isEmpty()) {
      throw new IllegalArgumentException(fieldName + " can't be empty");
    }
  }

  public static void validateListSize(List<?> list, int maxSize, String fieldName) {

    if (list.size() > maxSize) {
      throw new IllegalArgumentException(fieldName + " can't have more than " + maxSize + " items");
    }
  }

}
