package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the chatbot Qlin.
 */
public class Qlin {

    private static Boolean isTerminate;
    private static Scanner sc;

    /**
     * Returns a Qlin object.
     * This method initializes the chatbot.
     */
    public Qlin() {
        initialize();
    }

    /**
     * Start initializing and runs the run() method.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        initialize();
        UI.printMessage(UI.getGreetingString());
        while (!isTerminate) {
            run();
        }
    }

    /**
     * Initialize the chatbot and prints the greeting message.
     */
    private static void initialize() {
        sc = new Scanner(System.in);
        isTerminate = false;
        Storage.initialize();
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
            UI.printMessage(e.getMessage());
            isTerminate = true;
        }
    }

    /**
     * Returns the current status of the chatbot.
     * @return boolean isTerminate.
     */
    public boolean getStatus() {
        return isTerminate;
    }

    /**
     * Terminates the chatbot and stores the data.
     */
    public static void terminate() {
        Qlin.isTerminate = true;
        Storage.store();
        sc.close();
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
        if (!isTerminate) {
            String result;
            try {
                result = Processor.process(input);
            } catch (QlinException e) {
                result = e.getMessage();
            }
            return result;
        }
        return null;
    }
}
