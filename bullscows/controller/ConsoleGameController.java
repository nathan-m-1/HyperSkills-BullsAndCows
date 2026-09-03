package bullscows.controller;

import bullscows.application.GameService;
import bullscows.model.GuessResult;

public class ConsoleGameController {

    private final GameService gameService;

    public ConsoleGameController(GameService gameService) {
        this.gameService = gameService;
    }

    public ResponseDto makeGuessCode(String guess) {
        GuessResult result = gameService.guessCode(guess);

        return new ResponseDto(result.bulls(), result.cows(), result.secret());
    }
}
