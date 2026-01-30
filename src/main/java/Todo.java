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
        if (isDone) return "todo /" + taskName + " /1";
        return "todo /" + taskName + " /0";
    }
}
