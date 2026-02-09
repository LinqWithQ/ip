package exceptions;

import qlin.TrackList;

/**
 * The class that represent the invalid input command.
 */
public class InvalidInputException extends QlinException {

    /**
     * Returns a InvalidInputException object.
     */
    public InvalidInputException() {
        super("Sry, your input is invalid\n" + "Valid commands: \"list\", \"mark\", \"unmark\", \"todo\", "
                + "\"deadline\", \"event\", \"delete\", \"find\"");
    }
}
