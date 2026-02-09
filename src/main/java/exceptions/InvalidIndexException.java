package exceptions;

import qlin.TrackList;

/**
 * The class that represent the invalid input for indexing error.
 */
public class InvalidIndexException extends QlinException {

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, pls try again with a valid index ranged [1, " + (TrackList.size() - 1) + "].");
    }
}
