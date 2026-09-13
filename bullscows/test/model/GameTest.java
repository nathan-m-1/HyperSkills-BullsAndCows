package bullscows.test.model;

import bullscows.model.BullsAndCowsGame;
import bullscows.model.GuessResult;

public class GameTest {

    private static int passed;
    private static int failed;

    public static void main() {

        System.out.println("Initiation Test...");

        runTest(GameTest::shouldReturnOneCow, "shouldReturnOneCow");
        runTest(GameTest::shouldReturnThreeCows, "shouldReturnThreeCows");
        runTest(GameTest::shouldReturnFourCows, "shouldReturnFourCows");
        runTest(GameTest::shouldReturnOneBull, "shouldReturnOneBull");
        runTest(GameTest::shouldReturnThreeBulls, "shouldReturnThreeBulls");
        runTest(GameTest::shouldReturnFourBulls, "shouldReturnFourBulls");
        runTest(GameTest::shouldReturnOneCowAndOneBull, "shouldReturnOneCowAndOneBull");
        runTest(GameTest::shouldReturnNone, "shouldReturnNone");

        System.out.println();
        System.out.println("Test Complete.");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

    }

    private static void runTest(Runnable test, String testName){
        try {
            test.run();
            passed++;
        }catch (AssertionError e){
            failed++;
            System.out.printf("%s FAILED: %s%n", testName, e.getMessage());
        }
    }

    private static void shouldReturnOneCow(){
        int expectedResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("1234");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private static void shouldReturnThreeCows(){
        int expectedResult = 3;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("0000");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private static void shouldReturnFourCows(){
        int expectedResult = 4;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("3059");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private static void shouldReturnOneBull(){
        int expectedResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("9777");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private static void shouldReturnThreeBulls(){
        int expectedResult = 3;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("9306");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private static void shouldReturnFourBulls(){
        int expectedResult = 4;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("9305");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private static void shouldReturnOneCowAndOneBull(){
        int expectedCowsResult = 1;
        int expectedBullsResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("9883");
        if(!result.bulls().equals(expectedBullsResult) && !result.cows().equals(expectedCowsResult)){
            throw new AssertionError(String.format("Expected %d bulls and %d cows but got %d bulls and %d cows",
                    expectedCowsResult, expectedBullsResult, result.bulls(), result.cows()));
        }
    }

    private static void shouldReturnNone(){
        int expectedCowsResult = 0;
        int expectedBullsResult = 0;
        BullsAndCowsGame game = new BullsAndCowsGame();
        GuessResult result = game.guessCode("1111");
        if(!result.bulls().equals(expectedBullsResult) && !result.cows().equals(expectedCowsResult)){
            throw new AssertionError(String.format("Expected %d bulls and %d cows but got %d bulls and %d cows",
                    expectedCowsResult, expectedBullsResult, result.bulls(), result.cows()));
        }
    }
}
