package qlin;

/**
 * The class that represent todo tasks.
 */
public class Todo extends Task {

    /**
     * Returns a Todo object.
     * @param name The task's name.
     */
    public Todo(String name) {
        super(name);
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI
     * @return Task's string in format for UI
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    @Override
    public String toStoreFormat() {
        String result;
        result = "todo /" + this.taskName;
        if (this.isDone) {
            result += (" /1");
        } else {
            result += (" /0");
        }
        return result;
    }
}
