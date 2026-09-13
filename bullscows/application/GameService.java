package bullscows.application;

import bullscows.model.BullsAndCowsGame;
import bullscows.model.GuessResult;

public class  GameService {

    private final BullsAndCowsGame game;
    private final SecretNumberGenerator generator;

    public GameService(BullsAndCowsGame game) {
        this.game = game;
    }

    public void startGame(int length) {
        String secretCode = generator.generate();
        game = new BullsAndCowsGame()
    }

    public GuessResult guessCode(String guess) {
        return game.guessCode(guess);
    }

    public void generateRandomSecretCode(int length) {
        game.generateRandomSecretCode(length);
    }
}
