package bullscows.model;

import java.util.Random;

public class SecretNumberGenerator {

    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";

    public String generate(int length, int lengthPossibleSymbols) {

        if(length > lengthPossibleSymbols){
            throw new IllegalArgumentException("The length of the secret number should be less than or equal of length of the symbols");
        }

        String rangeSymbols = SYMBOLS.substring(0, lengthPossibleSymbols);
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        while (secretCode.length() < length) {
            char character = rangeSymbols.charAt(random.nextInt(rangeSymbols.length()));
            if(secretCode.indexOf(String.valueOf(character)) == -1) {
                secretCode.append(character);
            }
        }
        return secretCode.toString();
    }
}
