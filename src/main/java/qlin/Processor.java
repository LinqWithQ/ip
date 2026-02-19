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
    private final TrackList trackList;
    private final UI ui;
    private final InputChecker inputChecker = new InputChecker();
    private final Parser parser = new Parser();
    private final Qlin qlin;

    /**
     * Returns a Processor object.
     * @param trackList The TrackList object to be accessed.
     * @param ui The UI object to be interacted.
     * @param qlin The Qlin object that's using this Processor object.
     */
    public Processor(TrackList trackList, UI ui, Qlin qlin) {
        this.trackList = trackList;
        this.ui = ui;
        this.qlin = qlin;
    }
    /**
     * Response accordingly to the input, may either return a string object or throw a QlinException object.
     * @param input The string object that represent the user input.
     * @return A string object that represent the chatbot's output.
     * @throws QlinException The supertype of all exception objects thrown by this method.
     */
    public String process(String input) throws QlinException {
        String[] inputs = this.parser.parseBySpace(input);
        this.inputChecker.checkCommand(inputs);
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
            this.trackList.deleteAll();
            result = this.ui.getDeleteAllString();
        }
        default -> {
            assert false : "shouldn't reach here";
            this.qlin.terminate();
            throw new QlinException("Unknown error occurred: error position Processor.java");
        }
        }
        return result;
    }
    /**
     * Returns a message for bye command.
     * @return The string object to be shown.
     */
    private String processBye() {
        this.qlin.terminate();
        return this.ui.getByeString();
    }
    /**
     * Returns a message for list command.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processList() throws QlinException {
        if (this.trackList.getSize() == 0) {
            throw new NoElementException();
        }
        return this.ui.getTracklistContentString();
    }
    /**
     * Returns a message for todo command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     */
    private String processTodo(String[] inputs) {
        Task t = new Todo(inputs[1]);
        this.trackList.addTask(t);
        return this.ui.getAddTaskString(t);
    }
    /**
     * Returns a message for deadline command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processDeadline(String[] inputs) throws QlinException {
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(inputs[2], FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidDateTimeException();
        }
        Task t = new Deadline(inputs[1], dateTime);
        this.trackList.addTask(t);
        return this.ui.getAddTaskString(t);
    }
    /**
     * Returns a message for event command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processEvent(String[] inputs) throws QlinException {
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
        this.trackList.addTask(t);
        return this.ui.getAddTaskString(t);
    }
    /**
     * Returns a message for mark command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processMark(String[] inputs) throws QlinException {
        if (this.trackList.getSize() == 0) {
            throw new NoElementException();
        }
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (index >= this.trackList.getSize() || index < 0) {
            throw new InvalidIndexException(this.trackList);
        }
        Task t = this.trackList.getTask(index);
        t.setDone();
        return this.ui.getMarkTaskString(t);
    }
    /**
     * Returns a message for unmark command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processUnmark(String[] inputs) throws QlinException {
        if (this.trackList.getSize() == 0) {
            throw new NoElementException();
        }
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (index >= this.trackList.getSize() || index < 0) {
            throw new InvalidIndexException(this.trackList);
        }
        Task t = this.trackList.getTask(index);
        t.undone();
        return this.ui.getUnmarkTaskString(t);
    }
    /**
     * Returns a message for delete command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processDelete(String[] inputs) throws QlinException {
        int index;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
        } catch (NumberFormatException e) {
            throw new QlinException("Sry, an integer is expected for second parameter.");
        }
        if (this.trackList.getSize() == 0) {
            throw new NoElementException();
        }
        if (index >= this.trackList.getSize() || index < 0) {
            throw new InvalidIndexException(this.trackList);
        }
        Task t = this.trackList.getTask(index);
        this.trackList.deleteTask(index);
        return this.ui.getDeleteString(t);
    }
    /**
     * Returns a message for find command.
     * @param inputs Parsed user input.
     * @return The string object to be shown.
     * @throws QlinException The super type of all exceptions class for QLin.
     */
    private String processFind(String[] inputs) throws QlinException {
        if (this.trackList.getSize() == 0) {
            throw new NoElementException();
        }
        List<Task> tasks = this.trackList.searchName(inputs[1]);
        return this.ui.getFindString(tasks);
    }
}
