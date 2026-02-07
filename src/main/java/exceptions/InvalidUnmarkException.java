package exceptions;

public class InvalidUnmarkException extends QlinException {

    @Override
    public void echo() {
        System.out.println("Sry, index number is required");
        System.out.println("Pls follow this format: find /<index>");

    }
}
