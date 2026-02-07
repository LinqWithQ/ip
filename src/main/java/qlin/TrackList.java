package qlin;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that represent a container for Task objects.
 */
public class TrackList {

    private static List<Task> tasks = new ArrayList<>();

    /**
     * Adds a Task object to the container.
     * @param t A Task object.
     */
    public static void add(Task t) {
        tasks.add(t);
    }

    /**
     * Deletes a Task object from the container.
     * @param i The index of the Task object to be deleted.
     */
    public static void delete(int i) {
        tasks.remove(i);
    }

    /**
     * Returns a Task object from the container.
     * @param i The index of the Task object to be returned.
     * @return A Task object.
     */
    public static Task get(int i) {
        return tasks.get(i);
    }

    /**
     * Returns the number of Task object in the container.
     * @return An integer.
     */
    public static int size() {
        return tasks.size();
    }

    /**
     * Returns the container.
     * @return A List object.
     */
    public static List<Task> getList() {
        return tasks;
    }

    /**
     * Clears the container
     */
    public static void deleteAll() {
        tasks = new ArrayList<>();
    }

    /**
     * Returns a list that contains Task objects that contains the search name.
     * @param name A string.
     * @return A list.
     */
    public static List<Task> searchName(String name) {
        List<Task> result = new ArrayList<>();
        for (Task t: tasks) {
            if (t.getName().contains(name)) {
                result.add(t);
            }
        }
        return result;
    }
}
