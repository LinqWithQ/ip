package exceptions;

/**
 * The class that represent the invalid input for deadline command.
 */
public class InvalidDeadlineException extends QlinException {

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, your input format is wrong");
        System.out.println("Pls follow this format: deadline /<name> /<deadline time>");
    }
}
