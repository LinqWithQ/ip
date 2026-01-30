public class Task {
    protected boolean isDone;
    protected final String taskName;

    public Task(String n) {
        this.isDone = false;
        this.taskName = n;
    }

    public void setDone() {
        this.isDone = true;
    }

    public void unDone() {
        this.isDone = false;
    }

    public String getName() { return this.taskName; }

    @Override
    public String toString() {
        if (isDone) return "[X] " + taskName;
        return "[ ] " + taskName;
    }

    public String toStoreFormat() {
        if (this.isDone) return "task /" + this.taskName + " /1";
        return "task /" + this.taskName + " /0";
    }
}
