package qlin;

import exceptions.InvalidInputException;
import exceptions.QlinException;

/**
 * The class for checking the validation of the user input.
 */
public class InputChecker {
    private static final int[] BYE_PARAMETER = new int[] {1};
    private static final int[] LIST_PARAMETER = new int[] {1};
    private static final int[] TODO_PARAMETER = new int[] {2};
    private static final int[] DEADLINE_PARAMETER = new int[] {3};
    private static final int[] EVENT_PARAMETER = new int[] {4, 5};
    private static final int[] MARK_PARAMETER = new int[] {2};
    private static final int[] UNMARK_PARAMETER = new int[] {2};
    private static final int[] FIND_PARAMETER = new int[] {2};
    private static final int[] DELETE_PARAMETER = new int[] {2};

    /**
     * Returns nothing if the user input's format is correct.
     * DateTime is not check by this method.
     * @param inputs The user's input.
     * @throws QlinException Exception to be thrown if the user's input isn't valid.
     */
    public static void checkCommand(String[] inputs) throws QlinException {
        assert inputs.length != 0 : "the array shouldn't be empty";
        checkEmpty(inputs);
        switch (inputs[0]) {
        case "bye" -> check(inputs, inputs[0], BYE_PARAMETER);
        case "list" -> check(inputs, inputs[0], LIST_PARAMETER);
        case "todo" -> check(inputs, inputs[0], TODO_PARAMETER);
        case "deadline" -> check(inputs, inputs[0], DEADLINE_PARAMETER);
        case "event" -> check(inputs, inputs[0], EVENT_PARAMETER);
        case "mark" -> check(inputs, inputs[0], MARK_PARAMETER);
        case "unmark" -> check(inputs, inputs[0], UNMARK_PARAMETER);
        case "find" -> check(inputs, inputs[0], FIND_PARAMETER);
        case "delete" -> check(inputs, inputs[0], DELETE_PARAMETER);
        case "deleteAll" -> {
            return; // special command, do nothing.
        }
        default -> throw new InvalidInputException();
        }
    }
    /**
     * Check if there is any empty string in the string array.
     * @param inputs The user's input in the form of String[].
     * @throws QlinException Exception thrown if empty string is found.
     */
    private static void checkEmpty(String[] inputs) throws QlinException {
        for (String s: inputs) {
            if (s.isEmpty()) {
                throw new QlinException("Sry, empty argument detected, pls try again.");
            }
        }
    }

    /**
     * Check if the user input is correct, if no throws a QlinException object.
     * @param inputs The user's input.
     * @param commandType The command from the user input.
     * @param amounts The array that contains the amount of parameter that the specific command should contain.
     * @throws QlinException Exception to be thrown.
     */
    private static void check(String[] inputs, String commandType, int[] amounts) throws QlinException {
        boolean error = true;
        for (int amount: amounts) {
            if (inputs.length == amount) {
                error = false;
                break;
            }
        }
        if (error) {
            getQlinException(commandType);
        }
    }

    /**
     * Throws the right exception with the right message.
     * @param commandType The command type from the user input.
     * @throws QlinException The exception that carries the message.
     */
    private static void getQlinException(String commandType) throws QlinException {
        switch (commandType) {
        case "bye" -> throw new QlinException("Sry, extra parameters/s detected. Do you mean \"bye\"?");
        case "list" -> throw new QlinException("Sry, extra parameters/s detected. Do you mean \"list\"?");
        case "todo" -> throw new QlinException("Sry, pls follow this format: "
                + "todo <name>");
        case "deadline" -> throw new QlinException("Sry, pls follow this format: "
                + "deadline <name> <deadline datetime>");
        case "event" -> throw new QlinException("Sry, pls follow this format: "
                + "event <name> <starting datetime> <ending datetime>"
                + "\nor: event <name> <starting datetime> <ending datetime> <location>");
        case "mark" -> throw new QlinException("Sry, pls follow this format: "
                + "mark <index>");
        case "unmark" -> throw new QlinException("Sry, pls follow this format: "
                + "unmark <index>");
        case "delete" -> throw new QlinException("Sry, pls follow this format: "
                + "delete <index>");
        case "find" -> throw new QlinException("Sry, pls follow this format: "
                + "find <search name>");
        default -> {
            assert false : "shouldn't reach here";
            Qlin.terminate();
            throw new QlinException("Unknown error occurred: error position InputChecker.java");
        }
        }
    }
}
