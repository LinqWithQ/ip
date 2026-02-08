package exceptions;

/**
 * The class that represent the root exception for the chatbot.
 * A general exception.
 */
public class QlinException extends Exception {

    private String message;

    /**
     * Returns a QlinException objects.
     * @param message A string to be printed.
     */
    public QlinException(String message) {
        super();
        this.message = message;
    }

    /**
     * Overloaded constructor to be used by subtypes.
     */
    public QlinException() {
        super();
    }

    public String getMessage() {
        return this.message;
    }

    /**
     * Prints the error message.
     */
    public void echo() {
        System.out.println(this.message);
    }
}
