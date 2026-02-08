package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import exceptions.InvalidDateTimeException;
import exceptions.InvalidDeadlineException;
import exceptions.InvalidDeleteException;
import exceptions.InvalidEventException;
import exceptions.InvalidFindException;
import exceptions.InvalidIndexException;
import exceptions.InvalidInputException;
import exceptions.InvalidMarkException;
import exceptions.InvalidTodoException;
import exceptions.InvalidUnmarkException;
import exceptions.NoElementException;
import exceptions.QlinException;

/**
 * The class that contain the method for main logic of the chatbot.
 */
public class Processor {

    private static Scanner sc;
    private static Boolean isTerminate;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    /**
     * Returns nothing.
     * Used to pass the scanner to Processor class.
     * @param sc A Scanner object.
     * @param isTerminate A boolean object.
     */
    public static void setup(Scanner sc, Boolean isTerminate) {
        Processor.sc = sc;
        Processor.isTerminate = isTerminate;
    }

    /**
     * Returns nothing.
     * The main component of logic.
     * Read the input from CLI with a scanner and perform the command or throws corresponding exceptions.
     * It also calls methods from UI to create responds accordingly.
     * @throws QlinException The super type for all the exceptions that are thrown by the method.
     */
    public static void process() throws QlinException {
        String input = sc.nextLine();
        String[] inputs = Parser.breakString(input);

        // for debugging purpose
        /*
        for (String s: inputs) {
            System.out.println(s);
        }
        */

        switch (inputs[0]) {
        case "bye" -> {
            UI.printBye();
            isTerminate = true;
        }
        case "list" -> {
            if (TrackList.size() == 0) {
                throw new NoElementException();
            }
            UI.printList();
        }
        case "todo" -> {
            if (inputs.length == 1) {
                throw new InvalidTodoException();
            } else {
                Task t = new Todo(inputs[1]);
                TrackList.add(t);
            }
        }
        case "deadline" -> {
            if (inputs.length <= 2) {
                throw new InvalidDeadlineException();
            } else {
                LocalDateTime dateTime;
                try {
                    dateTime = LocalDateTime.parse(inputs[2], FORMATTER);
                } catch (DateTimeParseException e) {
                    throw new InvalidDateTimeException();
                }
                Task t = new Deadline(inputs[1], dateTime);
                TrackList.add(t);
                UI.printAddTask(t);
            }
        }
        case "event" -> {
            if (inputs.length <= 3) {
                throw new InvalidEventException();
            } else {
                LocalDateTime dateTime1;
                LocalDateTime dateTime2;
                try {
                    dateTime1 = LocalDateTime.parse(inputs[2], FORMATTER);
                    dateTime2 = LocalDateTime.parse(inputs[3], FORMATTER);
                } catch (DateTimeParseException e) {
                    throw new InvalidDateTimeException();
                }
                Task t = new Event(inputs[1], dateTime1, dateTime2);
                TrackList.add(t);
                UI.printAddTask(t);
            }
        }
        case "mark" -> {
            if (inputs.length == 1) {
                throw new InvalidMarkException();
            } else {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                t.setDone();
                UI.printMarkTask(t);
            }
        }
        case "unmark" -> {
            if (inputs.length == 1) {
                throw new InvalidUnmarkException();
            } else {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                t.undone();
                UI.printUnmarkTask(t);
            }
        }
        case "delete" -> {
            if (inputs.length == 1) {
                throw new InvalidDeleteException();
            } else {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                TrackList.delete(index);
                UI.printDelete(t);
            }
        } case "find" -> {
            if (inputs.length == 1) {
                throw new InvalidFindException();
            } else {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                List<Task> tasks = TrackList.searchName(inputs[1]);
                UI.printFind(tasks);
            }
        }

        // special command
        case "delete all" -> {
            TrackList.deleteAll();
            UI.printDeleteAll();
        }
        default -> throw new InvalidInputException();
        }
    }
}
