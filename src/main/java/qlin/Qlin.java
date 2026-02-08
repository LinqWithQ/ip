package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    private static Scanner sc;
    private static Boolean isTerminate;

    /**
     * The main method.
     * Clears the task list, then rebuild the list from history from qlin.txt.
     * Lastly, stores the list into qlin.txt when isTerminate is true.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        TrackList.deleteAll();
        sc = new Scanner(System.in);
        isTerminate = false;
        Processor.setup(sc, isTerminate);
        UI.printGreeting();
        Storage.initialize(sc, isTerminate);
        while (!isTerminate) {
            try {
                Processor.process();
            } catch (QlinException e) {
                e.echo();
            } catch (Exception e) {
                isTerminate = true;
            }
        }
        Storage.store();
    }
}
