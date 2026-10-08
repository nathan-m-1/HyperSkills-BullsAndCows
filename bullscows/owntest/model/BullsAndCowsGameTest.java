package bullscows.owntest.model;

import bullscows.model.BullsAndCowsGame;
import bullscows.model.GuessResult;

public class BullsAndCowsGameTest {

    private static int passed;
    private static int failed;

    void main(String[] args) {
        
        BullsAndCowsGameTest test = new BullsAndCowsGameTest(); 

        System.out.println("Initiation Test...");

        test.runTest(test::shouldReturnOneCow, "shouldReturnOneCow");
        test.runTest(test::shouldReturnThreeCows, "shouldReturnThreeCows");
        test.runTest(test::shouldReturnFourCows, "shouldReturnFourCows");
        test.runTest(test::shouldReturnOneBull, "shouldReturnOneBull");
        test.runTest(test::shouldReturnThreeBulls, "shouldReturnThreeBulls");
        test.runTest(test::shouldReturnFourBulls, "shouldReturnFourBulls");
        test.runTest(test::shouldReturnOneCowAndOneBull, "shouldReturnOneCowAndOneBull");
        test.runTest(test::shouldReturnNone, "shouldReturnNone");

        System.out.println();
        System.out.println("Test Complete.");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

    }

    private void runTest(Runnable test, String testName){
        try {
            test.run();
            passed++;
        }catch (AssertionError e){
            failed++;
            System.out.printf("%s FAILED: %s%n", testName, e.getMessage());
        }
    }

    private void shouldReturnOneCow(){
        int expectedResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("1234");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private void shouldReturnThreeCows(){
        int expectedResult = 3;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("0000");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private void shouldReturnFourCows(){
        int expectedResult = 4;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("3059");
        if(!result.cows().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d cows but got %d", expectedResult, result.cows()));
        }
    }

    private void shouldReturnOneBull(){
        int expectedResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("9777");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private void shouldReturnThreeBulls(){
        int expectedResult = 3;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("9306");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private void shouldReturnFourBulls(){
        int expectedResult = 4;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("9305");
        if(!result.bulls().equals(expectedResult)){
            throw new AssertionError(String.format("Expected %d bull but got %d", expectedResult, result.bulls()));
        }
    }

    private void shouldReturnOneCowAndOneBull(){
        int expectedCowsResult = 1;
        int expectedBullsResult = 1;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("9883");
        if(!result.bulls().equals(expectedBullsResult) && !result.cows().equals(expectedCowsResult)){
            throw new AssertionError(String.format("Expected %d bulls and %d cows but got %d bulls and %d cows",
                    expectedCowsResult, expectedBullsResult, result.bulls(), result.cows()));
        }
    }

    private void shouldReturnNone(){
        int expectedCowsResult = 0;
        int expectedBullsResult = 0;
        BullsAndCowsGame game = new BullsAndCowsGame("9305");
        GuessResult result = game.guessCode("1111");
        if(!result.bulls().equals(expectedBullsResult) && !result.cows().equals(expectedCowsResult)){
            throw new AssertionError(String.format("Expected %d bulls and %d cows but got %d bulls and %d cows",
                    expectedCowsResult, expectedBullsResult, result.bulls(), result.cows()));
        }
    }
}
