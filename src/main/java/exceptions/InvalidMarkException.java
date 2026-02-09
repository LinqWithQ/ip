package exceptions;

/**
 * The class that represent the invalid input for mark command.
 */
public class InvalidMarkException extends QlinException {

    /**
     * Returns a InvalidMarkException object.
     */
    public InvalidMarkException() {
        super("Sry, index number is required\n" + "Pls follow this format: mark /<index>");
    }
}
