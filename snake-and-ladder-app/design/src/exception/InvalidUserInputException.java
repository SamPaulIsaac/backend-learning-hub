package exception;

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
