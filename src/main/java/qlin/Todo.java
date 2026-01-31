package qlin;

public class Todo extends Task{

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
        if (this.isDone) {
            return "todo /" + this.taskName + " /1";
        } else {
            return "todo /" + this.taskName + " /0";
        }
    }
}
