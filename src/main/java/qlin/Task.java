package qlin;

/**
 * The class that represent task.
 */
public class Task {

    protected boolean isDone;
    protected final String taskName;

    /**
     * Returns a Task object.
     * @param name The task's name.
     */
    public Task(String name) {
        assert !name.isEmpty() : "name shouldn't be empty";
        this.isDone = false;
        this.taskName = name;
    }

    /**
     * Sets current task to done.
     */
    public void setDone() {
        this.isDone = true;
    }

    /**
     * Sets current task to not done.
     */
    public void undone() {
        this.isDone = false;
    }

    /**
     * Return the current task's name.
     * @return Task's name.
     */
    public String getName() {
        return this.taskName;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI.
     * @return Task's string in format for UI.
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + taskName;
        } else {
            return "[ ] " + taskName;
        }
    }

    /**
     * Returns a string in a format for storing purpose.
     * @return Task's string in format for qlin.txt.
     */
    public String toStoreFormat() {
        if (this.isDone) {
            return "task /" + this.taskName + " /1";
        } else {
            return "task /" + this.taskName + " /0";
        }
    }
}
