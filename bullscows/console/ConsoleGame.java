package bullscows.console;

import bullscows.controller.ConsoleGameController;
import bullscows.controller.ResponseDto;

public class ConsoleGame {

    private final ConsoleGameController controller;
    private final ConsoleInput input;

    public ConsoleGame(ConsoleGameController controller, ConsoleInput input) {
        this.controller = controller;
        this.input = input;
    }

    public void start() {

        System.out.println("Input the length of the secret code:");
        int codeLength = input.readInput();
        System.out.println("Input the number of possible symbols in the code:");
        int symbolsLength = input.readInput();

        controller.starGame(codeLength, symbolsLength);
        StringBuilder range = buildRange(codeLength, symbolsLength);
        System.out.printf("The secret is prepared: %s %s.%n", "*".repeat(codeLength), range);
        System.out.println("Okay, let's start a game!");
        ResponseDto responseDto = new ResponseDto(0, 0);
        int turn = 1;
        while(responseDto.bulls() != codeLength){
            System.out.printf("Turn %d:%n", turn);
            String guess = input.readGuess();
            responseDto = controller.makeGuessCode(guess);
            renderGuessResponse(responseDto);
            turn++;
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static StringBuilder buildRange(int codeLength, int symbolsLength) {
        StringBuilder range = new StringBuilder();
        range.append("(0");
        if(symbolsLength <= 1){
            range.append(")");
        } else if(symbolsLength <= 10){
            range.append("-").append(symbolsLength - 1).append(")");
        } else if(symbolsLength == 11){
            range.append("-").append(9).append(", ").append("a").append(")");
        } else {
            range.append("-").append(9).append(", ").append("a").append("-").append((char)('a' + (symbolsLength - 10) - 1)).append(")");
        }
        return range;
    }

    private void renderGuessResponse(ResponseDto responseDto) {
        System.out.println(buildGradeMessage(responseDto));
    }

    private String buildGradeMessage(ResponseDto responseDto) {
        int bulls = responseDto.bulls();
        int cows = responseDto.cows();

        StringBuilder grade = new StringBuilder("Grade: ");
        if(bulls > 0){
            grade.append(bulls).append(" bull(s)");
        }
        if(cows > 0){
            grade.append(bulls > 0 ? " and " : "");
            grade.append(cows).append(" cow(s)");
        }
        if(bulls == 0 && cows == 0){
            grade.append("None");
        }
        return grade.toString();
    }

}
