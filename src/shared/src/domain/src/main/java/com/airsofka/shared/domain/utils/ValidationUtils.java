package com.airsofka.shared.domain.utils;

public class ValidationUtils {
  public static void validateString(String input, String errorMessage) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static void validateMinLength(String input, int minLength, String errorMessage) {
    if (input == null || input.length() < minLength) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static void validateInteger(Integer input, String errorMessage) {
    if (input == null || input < 0) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static void validateNotNull(Object input, String errorMessage) {
    if (input == null) {
      throw new IllegalArgumentException(errorMessage);
    }
  }
}
