package exceptions;

/**
 * The class that represent the invalid input for todo command.
 */
public class InvalidTodoException extends QlinException {

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, name of a task cannot be empty.");
        System.out.println("Pls follow this format: todo /<name>");
    }
}
