package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the Chatbot Qlin.
 */
public class Qlin {

    private static Boolean isTerminate;
    private static Scanner sc;

    /**
     * Returns a Qlin object.
     * This method initialize the chatbot.
     */
    public Qlin() {
        isTerminate = false;
        sc = new Scanner(System.in);
        Storage.initialize();
    }

    /**
     * The main method for CLI.
     * Start initializing and prints the greeting message.
     * Starts the run() method;
     * Lastly, stores the list into qlin.txt when isTerminate is true.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        isTerminate = false;
        Storage.initialize();
        UI.printMessage(UI.getGreetingString());
        while (!isTerminate) {
            run();
        }
        sc.close();
    }

    /**
     * Runs the reading and processing of the user's input.
     */
    private static void run() {
        try {
            String input = sc.nextLine();
            String output = Processor.process(input);
            UI.printMessage(output);
        } catch (QlinException e) {
            UI.printMessage(e.getMessage());
        } catch (Exception e) {
            isTerminate = true;
        }
    }

    /**
     * Terminates the chatbot.
     */
    public static void terminate() {
        Qlin.isTerminate = true;
    }

    /**
     * Returns a string object for greeting.
     * @return A string object.
     */
    public static String getGreetingString() {
        return UI.getGreetingString();
    }

    /**
     * Returns a string which is the response of the chatbot.
     * @param input A string object which represent the user's input.
     * @return a string object.
     */
    public String getResponseString(String input) {
        String result;
        try {
            result = Processor.process(input);
        } catch (QlinException e) {
            result = e.getMessage();
        }
        return result;
    }
}
