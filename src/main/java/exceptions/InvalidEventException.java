package exceptions;

public class InvalidEventException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, your input format is invalid");
        System.out.println("Pls follow this format: event /<name> /<starting time> /<ending time>");
    }
}
