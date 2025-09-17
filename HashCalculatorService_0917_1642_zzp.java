// 代码生成时间: 2025-09-17 16:42:55
 * A service class for calculating hash values of strings using various algorithms.
 * This class demonstrates the use of Micronaut framework for dependency injection and
 * exception handling.
 */

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Singleton;

@Factory
public class HashCalculatorService {

    @Bean
    @Singleton
    public HashCalculator hashCalculator() {
        return new HashCalculator();
    }

    /**
     * A class that calculates hash values for a given input string.
     */
    public static class HashCalculator {

        /**
         * Calculates the hash value of the input string using the specified algorithm.
         *
         * @param input The input string to calculate the hash for.
         * @param algorithm The hashing algorithm to use (e.g., SHA-256).
         * @return The hash value of the input string.
         * @throws NoSuchAlgorithmException If the specified algorithm is not available.
         */
        public String calculateHash(String input, String algorithm) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
    }
}
