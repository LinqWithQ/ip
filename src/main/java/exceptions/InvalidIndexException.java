package exceptions;

import qlin.TrackList;

/**
 * The class that represent the invalid input for indexing error.
 */
public class InvalidIndexException extends QlinException {

    /**
     * Returns a InvalidIndexException object.
     */
    public InvalidIndexException() {
        super("Sry, pls try again with a valid index ranged [1, " + (TrackList.getSize() - 1) + "].");
    }
}
