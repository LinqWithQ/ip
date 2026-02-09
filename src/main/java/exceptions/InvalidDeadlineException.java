package exceptions;

/**
 * The class that represent the invalid input for deadline command.
 */
public class InvalidDeadlineException extends QlinException {
    public InvalidDeadlineException() {
        super("Sry, your input format is wrong\n" + "Pls follow this format: deadline /<name> /<deadline time>");
    }
}
