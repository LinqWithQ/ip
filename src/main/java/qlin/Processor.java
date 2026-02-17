package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import exceptions.InvalidDateTimeException;
import exceptions.InvalidIndexException;
import exceptions.NoElementException;
import exceptions.QlinException;


/**
 * The class that contain the method for main logic of the chatbot.
 */
public class Processor {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    /**
     * Response accordingly to the input, may either return a string object or throw a QlinException object.
     * @param input The string object that represent the user input.
     * @return A string object that represent the chatbot's output.
     * @throws QlinException The supertype of all exception objects thrown by this method.
     */
    public static String process(String input) throws QlinException {
        String[] inputs = Parser.parseBySpace(input);
        InputChecker.checkCommand(inputs);
        String result;
        switch (inputs[0]) {
        case "bye" -> result = processBye();
        case "list" -> result = processList();
        case "todo" -> result = processTodo(inputs);
        case "deadline" -> result = processDeadline(inputs);
        case "event" -> result = processEvent(inputs);
        case "mark" -> result = processMark(inputs);
        case "unmark" -> result = processUnmark(inputs);
        case "delete" -> result = processDelete(inputs);
        case "find" -> result = processFind(inputs);
        // special command
        case "deleteAll" -> {
            TrackList.deleteAll();
            result = UI.getDeleteAllString();
        }
        default -> {
            assert false : "shouldn't reach here";
            Qlin.terminate();
            throw new QlinException("Unknown error occurred: error position Processor.java");
        }
        }
        return result;
    }
    /**
     * Returns a message for bye command.
     * @return The string object to be shown.
     */
    private static String processBye() {
        Qlin.terminate();
        return UI.getByeString();
    }
    /**
     * Returns a message for list command.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processList() throws QlinException {
        if (TrackList.getSize() == 0) {
            throw new NoElementException();
        }
        return UI.getTracklistContentString();
    }
    /**
     * Returns a message for todo command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     */
    private static String processTodo(String[] inputs) {
        Task t = new Todo(inputs[1]);
        TrackList.addTask(t);
        return UI.getAddTaskString(t);
    }
    /**
     * Returns a message for deadline command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processDeadline(String[] inputs) throws QlinException {
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(inputs[2], FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDateTimeException();
        }
        Task t = new Deadline(inputs[1], dateTime);
        TrackList.addTask(t);
        return UI.getAddTaskString(t);
    }
    /**
     * Returns a message for event command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processEvent(String[] inputs) throws QlinException {
        LocalDateTime dateTimeStart;
        LocalDateTime dateTimeEnd;
        try {
            dateTimeStart = LocalDateTime.parse(inputs[2], FORMATTER);
            dateTimeEnd = LocalDateTime.parse(inputs[3], FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDateTimeException();
        }
        Task t;
        if (inputs.length == 4) {
            t = new Event(inputs[1], dateTimeStart, dateTimeEnd);
        } else {
            t = new Event(inputs[1], dateTimeStart, dateTimeEnd, inputs[4]);
        }
        TrackList.addTask(t);
        return UI.getAddTaskString(t);
    }
    /**
     * Returns a message for mark command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processMark(String[] inputs) throws QlinException {
        if (TrackList.getSize() == 0) {
            throw new NoElementException();
        }
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (index >= TrackList.getSize() || index < 0) {
            throw new InvalidIndexException();
        }
        Task t = TrackList.getTask(index);
        t.setDone();
        return UI.getMarkTaskString(t);
    }
    /**
     * Returns a message for unmark command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processUnmark(String[] inputs) throws QlinException {
        if (TrackList.getSize() == 0) {
            throw new NoElementException();
        }
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (index >= TrackList.getSize() || index < 0) {
            throw new InvalidIndexException();
        }
        Task t = TrackList.getTask(index);
        t.undone();
        return UI.getUnmarkTaskString(t);
    }
    /**
     * Returns a message for delete command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processDelete(String[] inputs) throws QlinException {
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (TrackList.getSize() == 0) {
            throw new NoElementException();
        }
        if (index >= TrackList.getSize() || index < 0) {
            throw new InvalidIndexException();
        }
        Task t = TrackList.getTask(index);
        TrackList.deleteTask(index);
        return UI.getDeleteString(t);
    }
    /**
     * Returns a message for find command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private static String processFind(String[] inputs) throws QlinException {
        if (TrackList.getSize() == 0) {
            throw new NoElementException();
        }
        List<Task> tasks = TrackList.searchName(inputs[1]);
        return UI.getFindString(tasks);
    }
}
