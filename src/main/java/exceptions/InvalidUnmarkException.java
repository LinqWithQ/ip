package exceptions;

/**
 * The class that represent the invalid input for unmark command.
 */
public class InvalidUnmarkException extends QlinException {

    /**
     * Returns a InvalidUnmarkException object.
     */
    public InvalidUnmarkException() {
        super("Sry, index number is required\n" + "Pls follow this format: unmark /<index>");
    }
}
