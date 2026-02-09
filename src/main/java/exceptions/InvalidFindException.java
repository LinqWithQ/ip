package exceptions;

/**
 * The class that represent the invalid input for find command.
 */
public class InvalidFindException extends QlinException {

    /**
     * Returns a InvalidFindException object.
     */
    public InvalidFindException() {
        super("Sry, search name is required\n"
                + "Pls follow this format: find /<name>");
    }
}
