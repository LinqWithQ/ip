package exceptions;

/**
 * The class that represent the invalid input for todo command.
 */
public class InvalidTodoException extends QlinException {

    /**
     * Returns a InvalidTodoException object.
     */
    public InvalidTodoException() {
        super("Sry, name of a task cannot be empty.\n" + "Pls follow this format: todo /<name>");
    }
}
