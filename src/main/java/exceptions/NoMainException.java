package exceptions;

public class NoMainException extends RuntimeException {

    public NoMainException() {
        super("No entry point method provided");
    }
}
