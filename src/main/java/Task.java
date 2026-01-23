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

    public String getString() {
        if (done) return "[X] " + taskName;
        return "[ ] " + taskName;
    }
}
