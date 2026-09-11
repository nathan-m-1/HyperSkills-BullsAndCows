package bullscows.owntest.model;

import bullscows.model.BullsAndCowsGame;

import java.util.HashSet;
import java.util.Set;

public class GameRandomSecretTest {

    private static int passed;
    private static int failed;

    void main() {

        System.out.println("Initiation Test...");

        runTest(GameRandomSecretTest::shouldReturnRandomSecretWithCorrectLength, "shouldReturnRandomSecretWithCorrectLength");
        runTest(GameRandomSecretTest::shouldReturnOnlyDigitsInSecretCode, "shouldReturnOnlyDigitsInSecretCode");
        runTest(GameRandomSecretTest::shouldNotRepeatDigitsInSecretCode, "shouldNotRepeatDigitsInSecretCode");

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

    private static void shouldReturnRandomSecretWithCorrectLength(){
        int expectedResult = 5;
        BullsAndCowsGame game = new BullsAndCowsGame();
        String secretCode = game.generateRandomSecretCode(expectedResult);
        if(!(secretCode.length() == expectedResult)){
            throw new AssertionError(String.format("Expected %d of length but got %d", expectedResult, secretCode.length()));
        }
    }

    private static void shouldReturnOnlyDigitsInSecretCode(){
        BullsAndCowsGame game = new BullsAndCowsGame();
        String secretCode = game.generateRandomSecretCode(10);
        if(!secretCode.matches("\\d+")){
            throw new AssertionError(String.format("Expected only digits but got %s", secretCode));
        }
    }

    private static void shouldNotRepeatDigitsInSecretCode(){
        BullsAndCowsGame game = new BullsAndCowsGame();
        String secretCode = game.generateRandomSecretCode(8);
        Set<Character> characters = new HashSet<>();

        for(char c : secretCode.toCharArray()){
            if(!characters.add(c)){
                throw new AssertionError(String.format("Expected not repeated characters but got %s", secretCode));
            }
        }
    }
}
