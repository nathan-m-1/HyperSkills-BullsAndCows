package bullscows.application;

import bullscows.model.BullsAndCowsGame;
import bullscows.model.GuessResult;

public class GameService {

    private final BullsAndCowsGame game;

    public GameService(BullsAndCowsGame game) {
        this.game = game;
    }

    public GuessResult guessCode(String guess) {
        return game.guessCode(guess);
    }

    public String generateRandomSecretCode(int length) {
        return game.generateRandomSecretCode(length);
    }
}
