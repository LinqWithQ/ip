package exceptions;

/**
 * The class that represent the invalid input for event command.
 */
public class InvalidEventException extends QlinException {
    /**
     * Returns a InvalidEventException object.
     */
    public InvalidEventException() {
        super("Sry, your input format is invalid\n"
                + "Pls follow this format: event /<name> /<starting time> /<ending time>");
    }
}
