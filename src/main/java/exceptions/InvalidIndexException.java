package exceptions;

public class InvalidIndexException extends QlinException{

    int highIndex;

    public InvalidIndexException(int index) {
        super();
        this.highIndex = index;
    }

    @Override
    public void echo() {
        System.out.println("Sry, pls try again with a valid index ranged [0, " + highIndex +"].");
    }
}
