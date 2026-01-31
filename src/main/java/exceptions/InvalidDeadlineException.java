package exceptions;

public class InvalidDeadlineException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, your input format is wrong");
        System.out.println("Consider this: deadline <name> /<starting time>");
    }
}
