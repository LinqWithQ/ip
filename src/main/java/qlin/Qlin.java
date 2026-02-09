package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    private static Boolean isTerminate = false;

    /**
     * The main method.
     * Clears the task list, then rebuild the list from history from qlin.txt.
     * Lastly, stores the list into qlin.txt when isTerminate is true.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        isTerminate = false;
        TrackList.deleteAll();
        Storage.initialize(sc, isTerminate);
        UI.printGreeting();
        while (!isTerminate) {
            try {
                String input = sc.nextLine();
                String output = Processor.process(input);
            } catch (QlinException e) {
                e.echo();
            } catch (Exception e) {
                isTerminate = true;
            }
        }
        Storage.store();
        sc.close();
    }

    /**
     * Terminates the chatbot.
     */
    public static void terminate() {
        Qlin.isTerminate = true;
    }

    /**
     * Returns a string which is the response of the chatbot.
     * @param input A string object which represent the user's input.
     * @return a string object.
     */
    public String getResponse(String input) {
        return "";
    }
}
