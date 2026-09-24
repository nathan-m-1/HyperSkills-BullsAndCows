package bullscows.application;

import bullscows.model.BullsAndCowsGame;
import bullscows.model.GuessResult;
import bullscows.model.SecretNumberGenerator;

public class  GameService {

    private BullsAndCowsGame game;
    private final SecretNumberGenerator generator;

    public GameService(SecretNumberGenerator generator) {
        this.generator = generator;
    }

    public void startGame(int length, int symbolsLength) {
        String secretCode = generator.generate(length, symbolsLength);
        game = new BullsAndCowsGame(secretCode);
    }

    public GuessResult guessCode(String guess) {
        return game.guessCode(guess);
    }

}
