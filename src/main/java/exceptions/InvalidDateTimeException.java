package exceptions;

/**
 * Class that represent the datetime format error for the chatbot.
 */
public class InvalidDateTimeException extends QlinException{

    /**
     * Prints the error message.
     */
    @Override
    public void echo() {
        System.out.println("Sry, the datetime format is invalid, pls follow this format: \"yyyy-MM-dd'T'HH:mm\"");
    }
}
