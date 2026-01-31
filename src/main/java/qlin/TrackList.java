package qlin;

import java.util.ArrayList;
import java.util.List;

public class TrackList {

    private static List<Task> tasks = new ArrayList<>();

    public static void add(Task t) {
        tasks.add(t);
    }

    public static void delete(int i) {
        tasks.remove(i);
    }

    public static Task get(int i) {
        return tasks.get(i);
    }

    public static int size() {
        return tasks.size();
    }

    public static List<Task> getList() {
        return tasks;
    }

    public static void deleteAll() {
        tasks = new ArrayList<>();
    }

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
