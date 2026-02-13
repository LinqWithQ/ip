package qlin;

import java.util.List;

/**
 * The class that represent the UI.
 */
public class UI {

    /**
     * Prints the given message.
     * @param message A string object.
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Returns the greeting message.
     * @return a string object.
     */
    public static String getGreetingMessage() {
        return "Hello! I'm Qlin.\n" + "What can I do for you?";
    }

    /**
     * Returns the goodbye message.
     * @return a string object.
     */
    public static String getByeMessage() {
        return "Goodbye, hope to not see you again!";
    }

    /**
     * Returns a string object that shows all tasks.
     * @return a string object.
     */
    public static String getShowTracklistMessage() {
        StringBuilder result = new StringBuilder("Here are the tasks in your list:");
        for (int x = 0; x < TrackList.getSize(); x++) {
            result.append("\n").append(x + 1).append(". ").append(TrackList.getTask(x).toString());
        }
        return result.toString();
    }

    /**
     * Returns a string object that indicates the marking of a task.
     * @param t A Task object.
     * @return a string object.
     */
    public static String getMarkTaskMessage(Task t) {
        return "Nice! I've marked this task as done:\n" + "  " + t.toString();
    }

    /**
     * Returns a string object that indicates the unmarking of a task.
     * @param t A Task object.
     * @return a string object.
     */
    public static String getUnmarkTaskMessage(Task t) {
        return "OK, I've marked this task as not done yet:\n" + "  " + t.toString();
    }

    /**
     * Returns a string object that indicates the adding of a task.
     * @param t A Task object.
     * @return a string object.
     */
    public static String getAddTaskMessage(Task t) {
        return "Got it. I've added this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + TrackList.getSize() + " tasks in the list.";
    }

    /**
     * Returns a string object that indicates the deleting of a task.
     * @param t A Task object.
     * @return a string object.
     */
    public static String getDeleteMessage(Task t) {
        return "Noted. I've removed this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + TrackList.getSize() + " tasks in the list.";
    }

    /**
     * Returns a string object that indicates the tasks in the list.
     * @param tasks A list that contains the tasks to be printed.
     * @return a string object.
     */
    public static String getFindMessage(List<Task> tasks) {
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
     * @return a string object.
     */
    public static String getDeleteAllMessage() {
        return "Ok, all tasks had been deleted.";
    }
}
