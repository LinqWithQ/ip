package exceptions;

public class InvalidTodoException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, name of a task cannot be empty.");
        System.out.println("Pls follow this format: todo /<name>");
    }
}
