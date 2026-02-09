package exceptions;

/**
 * The class that represent the invalid input for delete command.
 */
public class InvalidDeleteException extends QlinException {
    public InvalidDeleteException() {
        super("Sry, index number is required\n" + "Pls follow this format: delete /<index>");
    }
}
