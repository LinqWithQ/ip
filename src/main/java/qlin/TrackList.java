package qlin;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that represent a container for Task objects.
 */
public class TrackList {

    private List<Task> tasks = new ArrayList<>();

    /**
     * Adds a Task object to the container.
     * @param t A Task object.
     */
    public void addTask(Task t) {
        this.tasks.add(t);
    }

    /**
     * Deletes a Task object from the container.
     * @param i The index of the Task object to be deleted.
     */
    public void deleteTask(int i) {
        assert i >= 0 && i < this.tasks.size() : "index isn't valid";
        this.tasks.remove(i);
    }

    /**
     * Returns a Task object from the container.
     * @param i The index of the Task object to be returned.
     * @return A Task object.
     */
    public Task getTask(int i) {
        assert i >= 0 && i < this.tasks.size() : "index isn't valid";
        return this.tasks.get(i);
    }

    /**
     * Returns the number of Task object in the container.
     * @return An integer.
     */
    public int getSize() {
        return this.tasks.size();
    }

    /**
     * Returns the container.
     * @return A List object.
     */
    public List<Task> getList() {
        return this.tasks;
    }

    /**
     * Clears the container
     */
    public void deleteAll() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns a list that contains Task objects that contains the search name.
     * @param name A string.
     * @return A list.
     */
    public List<Task> searchName(String name) {
        assert !name.isEmpty() : "search name shouldn't be empty";
        List<Task> result = new ArrayList<>();
        for (Task t: this.tasks) {
            if (t.getName().contains(name)) {
                result.add(t);
            }
        }
        return result;
    }
}
