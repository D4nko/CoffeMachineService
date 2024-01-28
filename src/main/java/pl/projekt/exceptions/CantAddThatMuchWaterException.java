package pl.projekt.exceptions;

public class CantAddThatMuchWaterException extends RuntimeException{
    public CantAddThatMuchWaterException(String message) {
        super(message);
    }
}
