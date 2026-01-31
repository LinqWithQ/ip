package exceptions;

public class InvalidDeadlineTimeException extends InvalidDeadlineException{

    @Override
    public void echo() {
        System.out.println("Sry, deadline time cannot be empty.");
    }
}
