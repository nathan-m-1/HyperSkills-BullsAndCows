package bullscows.console;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String readGuess() {
        return scanner.nextLine();
    }

    public int readInput() {
        String input = scanner.nextLine();
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return number;
    }
}
