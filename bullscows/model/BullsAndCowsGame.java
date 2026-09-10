package bullscows.model;

import java.util.Random;

public class BullsAndCowsGame {

    private static final String SECRET_CODE = "9305";

    public GuessResult guessCode(String guess) {
        int cows = 0;
        int bulls = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (SECRET_CODE.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else if (SECRET_CODE.indexOf(guess.charAt(i)) >= 0) {
                cows++;
            }
        }
        return new GuessResult(bulls, cows, "9305");
    }

    public String generateRandomSecretCode(int length) {
        StringBuilder secretCode = new StringBuilder();
        while (secretCode.length() < length) {
            StringBuilder pseudoRandomNum = new StringBuilder(String.valueOf(System.nanoTime())).reverse();
            for (int i = 0; i < pseudoRandomNum.length(); i++) {
                if(secretCode.length() == length){break;}
                if(!(secretCode.indexOf(String.valueOf(pseudoRandomNum.charAt(i))) >= 0)) {
                    secretCode.append(pseudoRandomNum.charAt(i));
                }
            }
        }
        return secretCode.reverse().toString();
    }
}
