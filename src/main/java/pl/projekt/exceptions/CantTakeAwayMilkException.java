package pl.projekt.exceptions;

public class CantTakeAwayMilkException extends RuntimeException{
    public CantTakeAwayMilkException(String message) {
        super(message);
    }
}
