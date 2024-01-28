package pl.projekt.exceptions;

public class NotEnoughWaterException extends RuntimeException {
    public NotEnoughWaterException(String message) {
        super(message);
    }
}
