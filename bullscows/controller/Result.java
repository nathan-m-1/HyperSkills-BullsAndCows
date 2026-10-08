package bullscows.controller;

public record Result<T>(T value, ErrorCode errorCode, String message) {

    public boolean isSuccess() {
        return errorCode == null;
    }
}
