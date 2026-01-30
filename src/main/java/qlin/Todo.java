package qlin;

public class Todo extends Task{
    public Todo(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toStoreFormat() {
        if (this.isDone) return "todo /" + this.taskName + " /1";
        return "todo /" + this.taskName + " /0";
    }
}
