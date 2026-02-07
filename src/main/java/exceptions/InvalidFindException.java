package exceptions;

/**
 * The class that represent the invalid input for find command.
 */
public class InvalidFindException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, search name is required");
        System.out.println("Pls follow this format: find /<name>");
    }
}
