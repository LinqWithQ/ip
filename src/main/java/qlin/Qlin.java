package qlin;

import exceptions.*;
import java.util.Scanner;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    static boolean isTerminate;
    static Scanner sc;

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
        UI.printGreeting();
        Storage.initialize();
        while (!isTerminate) {
            try {
                Processor.process();
            } catch (QlinException e) {
                e.echo();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isTerminate = true;
            }
        }
        Storage.store();
    }
}
