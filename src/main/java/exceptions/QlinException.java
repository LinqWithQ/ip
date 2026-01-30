package exceptions;

public class QlinException extends Exception{
    String message;

    public QlinException(String message) {
        super();
        this.message = message;
    }

    public QlinException() {
        super();
    }

    public void echo() {
        System.out.println(this.message);
    }
}
