package exceptions;

/**
 * The class that represent the invalid input for deleting, finding, listing of an empty task list.
 */
public class NoElementException extends QlinException {

    /**
     * Returns a NoElementException object.
     */
    public NoElementException() {
        super("Sry, there is currently no task in the list.");
    }
}
