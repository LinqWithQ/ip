package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    /**
     * The main method.
     * Clears the task list, then rebuild the list from history from qlin.txt.
     * Lastly, stores the list into qlin.txt when isTerminate is true.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        TrackList.deleteAll();
        Scanner sc = new Scanner(System.in);
        Boolean isTerminate = false;
        Processor.setup(sc, isTerminate);
        Storage.initialize(sc, isTerminate);
        UI.printGreeting();
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
