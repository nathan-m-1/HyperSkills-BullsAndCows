package bullscows.test.model;

import bullscows.model.Game;
import bullscows.model.GuessResult;

public class GameTest {

    public static void main(String[] args) {

        System.out.println("Initiation Test...");

        shouldReturnOneCowAndTheSecretCode();

        System.out.println("Test Complete.");
        System.out.println("All tests passed!.");

    }

    private static void shouldReturnOneCowAndTheSecretCode(){

        Game game = new Game();

        GuessResult result = game.guessCode("1234");

        if(!result.cows().equals(1)){
            throw new AssertionError("Expected 1 cow but got " + result.cows());
        }
    }
}
