package exceptions;

/**
 * The class that represent the invalid input command.
 */
public class InvalidInputException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, your input is invalid");
        System.out.println("Valid commands: \"list\", \"mark\", \"unmark\", \"todo\", " +
                "\"deadline\", \"event\", \"delete\", \"find\"");
    }
}
