public class InvalidInputException extends QlinException{
    @Override
    public void echo() {
        System.out.println("Sry, your input is invalid");
    }
}
