package exceptions;

/**
 * The class that represent the invalid input for deleting, finding, listing of an empty task list.
 */
public class NoElementException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, there is currently no task in the list.");
    }
}
