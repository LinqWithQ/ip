package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    private static Boolean isTerminate = false;
    private static Scanner sc;

    /**
     * Returns a Qlin object.
     * This method initialize the chatbot.
     */
    public Qlin() {
        isTerminate = false;
        sc = new Scanner(System.in);
        Storage.initialize(sc, isTerminate);
    }

    /**
     * The main method.
     * Clears the task list, then rebuild the list from history from qlin.txt.
     * Lastly, stores the list into qlin.txt when isTerminate is true.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
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
        sc.close();
    }

    /**
     * Terminates the chatbot.
     */
    public static void terminate() {
        Qlin.isTerminate = true;
    }

    /**
     * Returns the greeting.
     * @return A string object.
     */
    public static String getGreeting() {
        return UI.printGreeting();
    }

    /**
     * Returns a string which is the response of the chatbot.
     * @param input A string object which represent the user's input.
     * @return a string object.
     */
    public String getResponse(String input) {
        String result;
        try {
            result = Processor.process(input);
        } catch (QlinException e) {
            result = e.getMessage();
        }
        return result;
    }
}
