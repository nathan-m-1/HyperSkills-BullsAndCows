package bullscows.model;

public class BullsAndCowsGame {

    private final String secretCode;

    public BullsAndCowsGame(String secretCode) {
        this.secretCode = secretCode;
    }

    public GuessResult guessCode(String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secretCode.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(guess.charAt(i)) >= 0) {
                cows++;
            }
        }
        return new GuessResult(bulls, cows);
    }

}
