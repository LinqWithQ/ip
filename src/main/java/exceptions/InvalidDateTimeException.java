package exceptions;

public class InvalidDateTimeException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, the datetime format is invalid, pls follow this format: \"yyyy-MM-dd'T'HH:mm\"");
    }
}
