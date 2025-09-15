// 代码生成时间: 2025-09-16 07:50:25
package com.example.app.service;

import io.micronaut.core.annotation.Introspected;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * TestDataGenerator is a class used to generate test data.
 * It provides methods for generating random strings, numbers, etc.,
 * which can be used for various testing scenarios.
 */
@Introspected
public class TestDataGenerator {

    /**
     * Generates a random alphanumeric string of specified length.
     *
     * @param length The length of the string to be generated.
     * @return A random alphanumeric string.
     */
    public String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomChar = ThreadLocalRandom.current().nextInt(0, 36);
            char c = (char) ('a' + randomChar);
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * Generates a random UUID.
     *
     * @return A random UUID.
     */
    public UUID generateRandomUUID() {
        return UUID.randomUUID();
    }

    /**
     * Generates a random integer within a specified range.
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (exclusive).
     * @return A random integer within the range.
     */
    public int generateRandomInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }

        return ThreadLocalRandom.current().nextInt(min, max);
    }

    // Additional methods for generating test data can be added here.

    // Example usage:
    // String randomString = generateRandomString(10);
    // UUID randomUUID = generateRandomUUID();
    // int randomInt = generateRandomInt(1, 100);
}
