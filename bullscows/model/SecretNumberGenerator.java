package bullscows.model;

import java.util.Random;

public class SecretNumberGenerator {

    public String generate(int length) {
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        while (secretCode.length() < length) {
            int digit = random.nextInt(10);
            if(secretCode.indexOf(String.valueOf(digit)) == -1) {
                secretCode.append(digit);
            }
        }
        return secretCode.toString();
    }
}
