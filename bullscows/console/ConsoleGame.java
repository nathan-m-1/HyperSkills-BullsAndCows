package bullscows.console;

import bullscows.controller.ConsoleGameController;
import bullscows.controller.ResponseDto;
import bullscows.controller.Result;

public class ConsoleGame {

    private final ConsoleGameController controller;
    private final ConsoleInput input;

    public ConsoleGame(ConsoleGameController controller, ConsoleInput input) {
        this.controller = controller;
        this.input = input;
    }

    public void start() {

        int codeLength = 0;
        int symbolsLength = 0;
        try {
            codeLength = input.readCodeLength();
            symbolsLength = input.readSymbolsLength();
        } catch (Exception e){
            // Already handled
            return;
        }

        Result<Void> result = controller.starGame(codeLength, symbolsLength);
        if(!result.isSuccess()){
            System.out.println(result.message());
            return;
        }

        StringBuilder range = buildRange(symbolsLength);
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

    private static StringBuilder buildRange(int symbolsLength) {
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
