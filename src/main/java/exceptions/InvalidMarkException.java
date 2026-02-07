package exceptions;

/**
 * The class that represent the invalid input for mark command.
 */
public class InvalidMarkException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, index number is required");
        System.out.println("Pls follow this format: find /<index>");
    }
}
