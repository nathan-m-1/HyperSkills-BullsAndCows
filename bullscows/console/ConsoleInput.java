package bullscows.console;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String readGuess() {
        return scanner.nextLine();
    }

    public int readCodeLength() {
        return readInput("Input the length of the secret code:");
    }

    public int readSymbolsLength() {
        return readInput("Input the number of possible symbols in the code:");
    }

    public int readInput(String message) {
        String input = "";
        int number = 0;
        boolean isNumber = false;
        try {
            System.out.println(message);
            input = scanner.nextLine();
            number = Integer.parseInt(input);
            isNumber = true;
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.", input);
            throw e;
        }
        return number;
    }
}
