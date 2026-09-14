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

        int codeLength = initiateGame();

        ResponseDto responseDto = new ResponseDto(0, 0);
        int turn = 1;
        while(responseDto.bulls() != codeLength){
            System.out.printf("Turn %d:%n", turn);
            String guess = input.readGuess();
            if (codeLength >= 10) {
                System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", codeLength);
                continue;
            }
            responseDto = controller.makeGuessCode(guess);
            renderGuessResponse(responseDto);
            turn++;
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    private int initiateGame() {
        System.out.println("Please, enter the secret code's length:");
        int codeLength = input.readSecretCodeLength();
        controller.starGame(codeLength);
        System.out.println("Okay, let's start a game!");
        return codeLength;
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
