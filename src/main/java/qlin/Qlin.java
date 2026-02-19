package qlin;

import java.util.Scanner;

import exceptions.QlinException;

/**
 * The class that represent the chatbot Qlin.
 */
public class Qlin {

    private Boolean isTerminate;
    private final Scanner sc;
    private final UI ui;
    private final Storage storage;
    private final TrackList trackList;
    private final Processor processor;

    /**
     * Returns a Qlin object.
     * This method initializes the chatbot.
     */
    public Qlin() {
        sc = new Scanner(System.in);
        isTerminate = false;
        this.trackList = new TrackList();
        this.ui = new UI(trackList);
        this.storage = new Storage(trackList, this);
        this.processor = new Processor(this.trackList, this.ui, this);
        this.storage.initialize();
        this.ui.printMessage(this.ui.getGreetingString());
    }

    /**
     * Start initializing and runs the run() method.
     * @param args An empty string.
     */
    public static void main(String[] args) {
        Qlin qlin = new Qlin();
        while (!qlin.isTerminate) {
            qlin.run();
        }
    }
    /**
     * Runs the reading and processing of the user's input.
     */
    private void run() {
        try {
            String input = sc.nextLine();
            String output = this.processor.process(input);
            this.ui.printMessage(output);
        } catch (QlinException e) {
            this.ui.printMessage(e.getMessage());
        } catch (Exception e) {
            this.ui.printMessage(e.getMessage());
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
    public void terminate() {
        this.isTerminate = true;
        this.storage.store();
        sc.close();
    }

    /**
     * Returns a string object for greeting.
     * @return A string object.
     */
    public String getGreetingString() {
        return this.ui.getGreetingString();
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
                result = this.processor.process(input);
            } catch (QlinException e) {
                result = e.getMessage();
            }
            return result;
        }
        return null;
    }
}
