package bullscows.test.model;

import bullscows.model.Game;
import bullscows.model.GuessResult;

public class GameTest {

    private static int passed;
    private static int failed;

    public static void main(String[] args) {

        System.out.println("Initiation Test...");

        runTest(GameTest::shouldReturnOneCowAndTheSecretCode);

        System.out.println();
        System.out.println("Test Complete.");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

    }

    private static void runTest(Runnable test){
        try {
            test.run();
            passed++;
        }catch (Throwable e){
            failed++;
            System.out.println("FAILED: " + e.getMessage());
        }
    }

    private static void shouldReturnOneCowAndTheSecretCode(){

        Game game = new Game();

        GuessResult result = game.guessCode("1234");

        if(!result.cows().equals(1)){
            throw new AssertionError("Expected 1 cow but got " + result.cows());
        }
    }
}
