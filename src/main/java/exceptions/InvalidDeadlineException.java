package exceptions;

public class InvalidDeadlineException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, your input format is wrong");
        System.out.println("Pls follow this format: deadline /<name> /<deadline time>");
    }
}
