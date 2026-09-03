package bullscows.model;

public class Game {

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
        return new GuessResult(cows, bulls, "9305");
    }
}
