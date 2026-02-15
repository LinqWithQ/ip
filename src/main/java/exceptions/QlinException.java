package exceptions;

/**
 * The class that represent the root exception for the chatbot.
 * A general exception.
 */
public class QlinException extends Exception {

    private final String message;

    /**
     * Returns a QlinException objects.
     * @param message A string to be printed.
     */
    public QlinException(String message) {
        super();
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
