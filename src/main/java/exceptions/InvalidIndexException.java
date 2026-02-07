package exceptions;

import qlin.TrackList;

public class InvalidIndexException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, pls try again with a valid index ranged [1, " + (TrackList.size()) +"].");
    }
}
