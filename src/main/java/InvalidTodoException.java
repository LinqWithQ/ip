public class InvalidTodoException extends QlinException{
    @Override
    public void echo() {
        System.out.println("Sry, name of a task cannot be empty.");
    }
}
