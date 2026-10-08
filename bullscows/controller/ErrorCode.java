package bullscows.controller;

public enum ErrorCode {
    LENGTH_SYMBOLS_GREATER_THAN_CODE_LENGTH("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols."),
    LENGTH_SYMBOLS_GREATER_THAN_POSSIBLE_SYMBOLS("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
