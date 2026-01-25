public class Task {
    private boolean done;
    private final String taskName;

    public Task(String n) {
        this.done = false;
        this.taskName = n;
    }

    public void setDone() {
        this.done = true;
    }

    public void unDone() {
        this.done = false;
    }

    public String getName() { return this.taskName; }
    @Override
    public String toString() {
        if (done) return "[X] " + taskName;
        return "[ ] " + taskName;
    }
}
