package qlin;

public class Task {

    protected boolean isDone;
    protected final String taskName;

    public Task(String n) {
        this.isDone = false;
        this.taskName = n;
    }

    /**
     * Sets current task to done
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Sets current task to not done
     */
    public void unDone() {
        this.isDone = false;
    }

    /**
     * Return the current task's name
     * @return Task's name
     */
    public String getName() {
        return this.taskName;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI
     * @return Task's string in format for UI
     */
    @Override
    public String toString() {
        if (isDone) return "[X] " + taskName;
        return "[ ] " + taskName;
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    public String toStoreFormat() {
        if (this.isDone) return "task /" + this.taskName + " /1";
        return "task /" + this.taskName + " /0";
    }
}
