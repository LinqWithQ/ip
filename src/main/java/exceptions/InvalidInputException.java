package exceptions;

/**
 * The class that represent the invalid input command.
 */
public class InvalidInputException extends QlinException {

    /**
     * Returns a InvalidInputException object.
     */
    public InvalidInputException() {
        super("Sry, your input is invalid\n" + "Valid commands: \"bye\", \"list\", \"mark\", \"unmark\", \"todo\", "
                + "\"deadline\", \"event\", \"delete\", \"find\"");
    }
}
