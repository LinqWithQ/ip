package exceptions;

/**
 * The class that represent the invalid input for event command.
 */
public class InvalidEventException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, your input format is invalid");
        System.out.println("Pls follow this format: event /<name> /<starting time> /<ending time>");
    }
}
