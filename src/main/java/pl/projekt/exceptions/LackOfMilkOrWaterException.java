package pl.projekt.exceptions;

public class LackOfMilkOrWaterException extends RuntimeException{
    public LackOfMilkOrWaterException(String message) {
        super(message);
    }
}
