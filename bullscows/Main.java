package bullscows;

import bullscows.application.GameService;
import bullscows.console.ConsoleGame;
import bullscows.console.ConsoleInput;
import bullscows.controller.ConsoleGameController;
import bullscows.model.BullsAndCowsGame;

public class Main {
    public static void main(String[] args) {

        BullsAndCowsGame game = new BullsAndCowsGame();

        GameService service = new GameService(game);

        ConsoleGameController controller = new ConsoleGameController(service);
        ConsoleInput input = new ConsoleInput();

        ConsoleGame consoleGame = new ConsoleGame(controller, input);
        consoleGame.start();
    }
}
