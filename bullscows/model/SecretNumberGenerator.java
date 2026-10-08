package bullscows.model;

import bullscows.controller.ErrorCode;

import java.util.Random;

public class SecretNumberGenerator {

    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyz";

    public String generate(int length, int lengthSymbols) {

        if(length > lengthSymbols){
            throw new IllegalArgumentException(ErrorCode.LENGTH_SYMBOLS_GREATER_THAN_CODE_LENGTH.name());
        }

        if(lengthSymbols > SYMBOLS.length()){
            throw new IllegalArgumentException(ErrorCode.LENGTH_SYMBOLS_GREATER_THAN_POSSIBLE_SYMBOLS.name());
        }

        String rangeSymbols = SYMBOLS.substring(0, lengthSymbols);
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
