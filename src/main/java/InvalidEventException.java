public class InvalidEventException extends QlinException{
    @Override
    public void echo() {
        System.out.println("Sry, your input format is invalid");
        System.out.println("Consider this: event <name> <starting time> <ending time>");
    }
}
