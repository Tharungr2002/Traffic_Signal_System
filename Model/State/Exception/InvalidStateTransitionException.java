package Model.State.Exception;

public class InvalidStateTransitionException extends RuntimeException{
    public InvalidStateTransitionException(String message) {
        super(message);
    }
}
