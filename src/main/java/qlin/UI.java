package qlin;

import java.util.List;

/**
 * The class that represent the UI.
 */
public class UI {

    /**
     * Prints the greeting message.
     */
    public static String printGreeting() {
        String result = "Hello! I'm Qlin.\n" + "What can I do for you?";
        System.out.println(result);
        return result;
    }

    /**
     * Prints the goodbye message.
     */
    public static String printBye() {
        String result = "Goodbye, hope to not see you again!";
        System.out.println(result);
        return result;
    }

    /**
     * Prints all tasks.
     */
    public static String printList() {
        String result = "Here are the tasks in your list:";
        for (int x = 0; x < TrackList.size(); x++) {
            result += "\n" + (x + 1) + ". " + TrackList.get(x).toString();
        }
        System.out.println(result);
        return result;
    }

    /**
     * Prints the marking of a task.
     * @param t A Task object.
     */
    public static String printMarkTask(Task t) {
        String result = "Nice! I've marked this task as done:\n" + "  " + t.toString();
        System.out.println(result);
        return result;
    }

    /**
     * Prints the unmarking of a task.
     * @param t A Task object.
     */
    public static String printUnmarkTask(Task t) {
        String result = "OK, I've marked this task as not done yet:\n" + "  " + t.toString();
        System.out.println(result);
        return result;
    }

    /**
     * Prints the adding of a task.
     * @param t A Task object.
     */
    public static String printAddTask(Task t) {
        String result = "Got it. I've added this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + TrackList.size() + " tasks in the list.";
        System.out.println(result);
        return result;
    }

    /**
     * Prints the deleting of a task.
     * @param t A Task object.
     */
    public static String printDelete(Task t) {
        String result = "Noted. I've removed this task:\n"
                + ("  " + t.toString())
                + "\nNow you have " + TrackList.size() + " tasks in the list.";
        System.out.println(result);
        return result;
    }

    /**
     * Prints the tasks in the list.
     * @param tasks A list that contains the tasks to be printed.
     */
    public static String printFind(List<Task> tasks) {
        String result;
        if (tasks.isEmpty()) {
            result = "No task with such name is found.";
        } else {
            result = "Here are the matching tasks in your list:";
            for (int i = 0; i < tasks.size(); i++) {
                result += "\n" + (i + 1) + ". " + tasks.get(i).toString();
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * Prints the deleting of all task.
     */
    public static String printDeleteAll() {
        System.out.println("Ok, all tasks had been deleted.");
        return "Ok, all tasks had been deleted.";
    }
}
