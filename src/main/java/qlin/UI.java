package qlin;

import java.util.List;

/**
 * The class that represent the UI.
 */
public class UI {
    private final TrackList trackList;

    /**
     * Returns a UI object.
     * @param trackList The TrackList object to be accessed.
     */
    public UI(TrackList trackList) {
        this.trackList = trackList;
    }

    /**
     * Prints the given message.
     * @param message The message to be printed.
     */
    public void printMessage(String message) {
        assert !message.isEmpty() : "message shouldn't be empty";
        System.out.println(message);
    }

    /**
     * Returns the greeting message.
     * @return the message to be shown.
     */
    public String getGreetingString() {
        return "Hello! I'm Qlin.\n"
                + "What can I do for you?";
    }

    /**
     * Returns the goodbye message.
     * @return the message to be shown.
     */
    public String getByeString() {
        return "Goodbye, hope to not see you again!";
    }

    /**
     * Returns a string object that shows all tasks.
     * @return the message to be shown.
     */
    public String getTracklistContentString() {
        StringBuilder result = new StringBuilder("Here are the tasks in your list:");
        for (int x = 0; x < this.trackList.getSize(); x++) {
            result.append("\n").append(x + 1).append(". ").append(this.trackList.getTask(x).toString());
        }
        return result.toString();
    }

    /**
     * Returns a string object that indicates the marking of a task.
     * @param t The current task object.
     * @return the message to be shown.
     */
    public String getMarkTaskString(Task t) {
        return "Nice! I've marked this task as done:\n"
                + "  " + t.toString();
    }

    /**
     * Returns a string object that indicates the unmarking of a task.
     * @param t The current task object.
     * @return the message to be shown.
     */
    public String getUnmarkTaskString(Task t) {
        return "OK, I've marked this task as not done yet:\n"
                + "  " + t.toString();
    }

    /**
     * Returns a string object that indicates the adding of a task.
     * @param t The current task object.
     * @return the message to be shown.
     */
    public String getAddTaskString(Task t) {
        return "Got it. I've added this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + this.trackList.getSize() + " tasks in the list.";
    }

    /**
     * Returns a string object that indicates the deleting of a task.
     * @param t The current task object.
     * @return the message to be shown.
     */
    public String getDeleteString(Task t) {
        return "Noted. I've removed this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + this.trackList.getSize() + " tasks in the list.";
    }

    /**
     * Returns a string object that indicates the tasks in the list.
     * @param tasks A list that contains the tasks to be printed.
     * @return the message to be shown.
     */
    public String getFindString(List<Task> tasks) {
        StringBuilder result;
        if (tasks.isEmpty()) {
            result = new StringBuilder("No task with such name is found.");
        } else {
            result = new StringBuilder("Here are the matching tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                result.append("\n").append(i + 1).append(". ").append(tasks.get(i).toString());
            }
        }
        return result.toString();
    }

    /**
     * Returns a string object that indicates the deleting of all task.
     * @return the message to be shown.
     */
    public String getDeleteAllString() {
        return "Ok, all tasks had been deleted.";
    }
}
