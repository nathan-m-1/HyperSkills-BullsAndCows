package bullscows.owntest.model;

import bullscows.model.SecretNumberGenerator;

import java.util.HashSet;
import java.util.Set;

public class SecretNumberGeneratorTest {

    private static int passed;
    private static int failed;
    
    private final SecretNumberGenerator secretNumberGenerator;
    
    public SecretNumberGeneratorTest() {
        secretNumberGenerator = new SecretNumberGenerator();
    }

    public static void main(String [] args) {
        SecretNumberGeneratorTest test = new SecretNumberGeneratorTest();

        System.out.println("Initiation Test...");

        test.runTest(test::shouldReturnRandomSecretWithCorrectLength, "shouldReturnRandomSecretWithCorrectLength");
        test.runTest(test::shouldReturnOnlyDigitsInSecretCode, "shouldReturnOnlyDigitsInSecretCode");
        test.runTest(test::shouldNotRepeatDigitsInSecretCode, "shouldNotRepeatDigitsInSecretCode");

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

    private void shouldReturnRandomSecretWithCorrectLength(){
        int expectedResult = 5;
        String secretCode = secretNumberGenerator.generate(expectedResult);
        if(!(secretCode.length() == expectedResult)){
            throw new AssertionError(String.format("Expected %d of length but got %d", expectedResult, secretCode.length()));
        }
    }

    private void shouldReturnOnlyDigitsInSecretCode(){
        String secretCode = secretNumberGenerator.generate(10);
        if(!secretCode.matches("\\d+")){
            throw new AssertionError(String.format("Expected only digits but got %s", secretCode));
        }
    }

    private void shouldNotRepeatDigitsInSecretCode(){
        String secretCode = secretNumberGenerator.generate(8);
        Set<Character> characters = new HashSet<>();

        for(char c : secretCode.toCharArray()){
            if(!characters.add(c)){
                throw new AssertionError(String.format("Expected not repeated characters but got %s", secretCode));
            }
        }
    }
}
