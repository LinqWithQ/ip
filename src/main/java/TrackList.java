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
    public static int getLen() {
        return tasks.size();
    }
    public static List<Task> getList() {
        return tasks;
    }
}
