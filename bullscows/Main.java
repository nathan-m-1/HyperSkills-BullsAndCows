package bullscows;

import bullscows.application.GameService;
import bullscows.console.ConsoleGame;
import bullscows.console.ConsoleInput;
import bullscows.controller.ConsoleGameController;
import bullscows.model.BullsAndCowsGame;
import bullscows.model.SecretNumberGenerator;

public class Main {
    public static void main(String[] args) {

        SecretNumberGenerator generator = new SecretNumberGenerator();

        GameService service = new GameService(generator);

        ConsoleGameController controller = new ConsoleGameController(service);
        ConsoleInput input = new ConsoleInput();

        ConsoleGame consoleGame = new ConsoleGame(controller, input);
        consoleGame.start();
    }
}
