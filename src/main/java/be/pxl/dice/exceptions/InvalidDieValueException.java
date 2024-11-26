package be.pxl.dice.exceptions;

public class InvalidDieValueException extends RuntimeException {
    public InvalidDieValueException() {
        super();
    }

    public InvalidDieValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDieValueException(Throwable cause) {
        super(cause);
    }

    protected InvalidDieValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidDieValueException(String message) {
        super(message);
    }
}
