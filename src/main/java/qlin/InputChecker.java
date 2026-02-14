package qlin;

import exceptions.InvalidInputException;
import exceptions.QlinException;

/**
 * The class for checking the validation of the user input.
 */
public class InputChecker {
    static final int BYE_PARAMETER = 1;
    static final int LIST_PARAMETER = 1;
    static final int TODO_PARAMETER = 2;
    static final int DEADLINE_PARAMETER = 3;
    static final int EVENT_PARAMETER = 4;
    static final int MARK_PARAMETER = 2;
    static final int UNMARK_PARAMETER = 2;
    static final int FIND_PARAMETER = 2;
    static final int DELETE_PARAMETER = 2;

    /**
     * Returns true if the user input's format is correct.
     * DateTime is not check by this method.
     * @param inputs The user's input.
     * @return True if the inputs is  valid.
     * @throws QlinException Exception to be thrown.
     */
    public static boolean check(String[] inputs) throws QlinException {
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
        default -> throw new InvalidInputException();
        }
        return true;
    }

    /**
     * Check if the user input is correct, if no throws a QlinException object.
     * @param inputs The user's input.
     * @param commandType The command from the user input.
     * @param amount The parameter number required.
     * @throws QlinException Exception to be thrown.
     */
    private static void check(String[] inputs, String commandType, int amount) throws QlinException {
        if (inputs.length != amount) {
            getQlinException(commandType);
        }
    }

    /**
     * Throws the right exception with the right message.
     * @param commandType The command from the user input.
     * @throws QlinException The exception that carries the message.
     */
    private static void getQlinException(String commandType) throws QlinException {
        switch (commandType) {
        case "bye" -> throw new QlinException("Sry, extra parameters/s detected. Do you mean \"bye\"?");
        case "list" -> throw new QlinException("Sry, extra parameters/s detected. Do you mean \"list\"?");
        case "todo" -> throw new QlinException("Sry, extra parameters/s detected. Pls follow this format: "
                + "todo /<name>");
        case "deadline" -> throw new QlinException("Sry, extra parameters/s detected. Pls follow this format: "
                + "deadline /<name> /<deadline datetime>");
        case "event" -> throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                + "event /<name> /<starting datetime> /<ending datetime>");
        case "mark" -> throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                + "mark /<index>");
        case "unmark" -> throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                + "unmark /<index>");
        case "find" -> throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                + "delete /<index>");
        case "delete" -> throw new QlinException("Sry, extra parameter/s detected. Pls follow this format: "
                + "find /<search name>");
        default -> throw new QlinException("Unknown error");
        }
    }
}
