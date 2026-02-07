package exceptions;

public class InvalidFindException extends QlinException{

    @Override
    public void echo() {
        System.out.println("Sry, search name is required");
        System.out.println("Pls follow this format: find /<name>");
    }
}
