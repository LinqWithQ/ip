package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

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

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    /**
     * The main component of logic.
     * Response accordingly to the input, may either return a string object or throw a QlinException object.
     * @param input The string object that represent the user input.
     * @return A string object that represent the chatbot's output.
     * @throws QlinException The supertype of all exception objects thrown by this method.
     */
    public static String process(String input) throws QlinException {
        String[] inputs = Parser.breakString(input);
        String result = "";
        switch (inputs[0]) {
        case "bye" -> {
            result = UI.printBye();
            Storage.store();
            Qlin.terminate();
        }
        case "list" -> {
            if (TrackList.size() == 0) {
                throw new NoElementException();
            }
            result = UI.printList();
        }
        case "todo" -> {
            if (inputs.length == 1) {
                throw new InvalidTodoException();
            } else if (inputs.length == 2) {
                Task t = new Todo(inputs[1]);
                TrackList.add(t);
                result = UI.printAddTask(t);
            } else {
                throw new QlinException("Sry, extra parameters/s detected.Pls follow this format: todo /<name>");
            }
        }
        case "deadline" -> {
            if (inputs.length <= 2) {
                throw new InvalidDeadlineException();
            } else if (inputs.length == 3) {
                LocalDateTime dateTime;
                try {
                    dateTime = LocalDateTime.parse(inputs[2], FORMATTER);
                } catch (DateTimeParseException e) {
                    throw new InvalidDateTimeException();
                }
                Task t = new Deadline(inputs[1], dateTime);
                TrackList.add(t);
                result = UI.printAddTask(t);
            } else {
                throw new QlinException("Sry, extra parameters/s detected.Pls follow this format: "
                        + "deadline /<name> /<deadline datetime>");
            }
        }
        case "event" -> {
            if (inputs.length <= 3) {
                throw new InvalidEventException();
            } else if (inputs.length == 4) {
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
                result = UI.printAddTask(t);
            } else {
                throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                        + "event /<name> /<starting datetime> /<ending datetime>");
            }
        }
        case "mark" -> {
            if (inputs.length == 1) {
                throw new InvalidMarkException();
            } else if (inputs.length == 2) {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                t.setDone();
                result = UI.printMarkTask(t);
            } else {
                throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                        + "mark /<index>");
            }
        }
        case "unmark" -> {
            if (inputs.length == 1) {
                throw new InvalidUnmarkException();
            } else if (inputs.length == 2) {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                t.undone();
                result = UI.printUnmarkTask(t);
            } else {
                throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                        + "unmark /<index>");
            }
        }
        case "delete" -> {
            if (inputs.length == 1) {
                throw new InvalidDeleteException();
            } else if (inputs.length == 2) {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                int index = Integer.parseInt(inputs[1]) - 1;
                if (index >= TrackList.size() || index < 0) {
                    throw new InvalidIndexException();
                }
                Task t = TrackList.get(index);
                TrackList.delete(index);
                result = UI.printDelete(t);
            } else {
                throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                        + "delete /<index>");
            }
        } case "find" -> {
            if (inputs.length == 1) {
                throw new InvalidFindException();
            } else if (inputs.length == 2) {
                if (TrackList.size() == 0) {
                    throw new NoElementException();
                }
                List<Task> tasks = TrackList.searchName(inputs[1]);
                result = UI.printFind(tasks);
            } else {
                throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                        + "find /<search name>");
            }
        }

        // special command
        case "delete all" -> {
            TrackList.deleteAll();
            result = UI.printDeleteAll();
        }
        default -> throw new InvalidInputException();
        }
        return result;
    }
}
