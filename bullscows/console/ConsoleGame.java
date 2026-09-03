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
        String guess = input.readGuess();
        ResponseDto responseDto = controller.makeGuessCode(guess);
        renderResponse(responseDto);
    }

    private void renderResponse(ResponseDto responseDto) {
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

        grade.append(". The secret code is ").append(responseDto.secret()).append(".");
        return grade.toString();
    }
}
