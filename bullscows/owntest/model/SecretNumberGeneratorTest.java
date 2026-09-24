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

    public static void main(String[] args) {
        SecretNumberGeneratorTest test = new SecretNumberGeneratorTest();

        System.out.println("Initiation Test...");

        test.runTest(test::shouldReturnSecretWithCorrectLength, "shouldReturnSecretWithCorrectLength");
        test.runTest(test::shouldNotRepeatCharacters, "shouldNotRepeatCharacters");
        test.runTest(test::shouldReturnOnlyLettersAndDigits, "shouldReturnOnlyLettersAndDigits");
        test.runTest(test::codeLengthNotGreaterThanLengthOfPossibleSymbols, "codeLengthNotGreaterThanLengthOfPossibleSymbols");

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

    private void shouldReturnSecretWithCorrectLength(){
        int expectedResult = 5;
        String secretCode = secretNumberGenerator.generate(expectedResult, 10);
        if(!(secretCode.length() == expectedResult)){
            throw new AssertionError(String.format("Expected %d of length but got %d", expectedResult, secretCode.length()));
        }
    }

    private void shouldNotRepeatCharacters(){
        String secretCode = secretNumberGenerator.generate(20, 36);
        Set<Character> characters = new HashSet<>();

        for(char c : secretCode.toCharArray()){
            if(!characters.add(c)){
                throw new AssertionError(String.format("Expected not repeated characters but got %s", secretCode));
            }
        }
    }

    private void shouldReturnOnlyLettersAndDigits(){
        String secretCode = secretNumberGenerator.generate(11, 11);

        if(!secretCode.matches("[a-z0-9]+")){
            throw new AssertionError(String.format("Expected letters and numbers but got %s", secretCode));
        }
    }

    private void codeLengthNotGreaterThanLengthOfPossibleSymbols(){

        IllegalArgumentException exceptionThrown = null;

        String secretCode = null;
        try {
            secretCode = secretNumberGenerator.generate(15, 10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = e;
        }

        if(exceptionThrown == null){
            throw new AssertionError(String.format("Expected IllegalArgumentException, but not thrown and got the code: %s", secretCode));
        }
    }
}
