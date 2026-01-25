public class NoElementException extends QlinException{
    @Override
    public void echo() {
        System.out.println("Sry, there is currently no task in the list.");
    }
}
