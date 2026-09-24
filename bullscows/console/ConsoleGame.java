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
        System.out.printf("The secret is prepared: %s (0-9, a-f).%n", "*".repeat(codeLength));
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
