package bullscows.console;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String readGuess() {
        return scanner.nextLine();
    }
}
