package qlin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The class that contain methods for creating, reading and writing of history text file, qlin.txt.
 */
public class Storage {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    /**
     * Clears the tracklist.
     * Reads the qlin.txt and rebuild the tracklist.
     * If no such file is found, then create a new file.
     */
    public static void initialize() {
        TrackList.deleteAll();
        Path path = Path.of("qlin.txt");
        if (!Files.exists(path)) {
            createFile(path);
        } else {
            rebuildTracklist(path);
        }
    }
    /**
     * Creates a local file "qlin.txt" for storing data.
     * Terminates the chatbot if error is detected.
     * @param path The file's path.
     */
    private static void createFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            System.err.println("Could not create file: " + e.getMessage());
            Qlin.terminate();
        }
    }

    /**
     * Creates a new scanner object to read the file.
     * Reads the file and adds the task object one by one through calling addTask() method.
     * @param path The file's path.
     */
    private static void rebuildTracklist(Path path) {
        try {
            Scanner sc = new Scanner(path);
            while (sc.hasNextLine()) {
                Storage.addTask(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Qlin.terminate();
        }
    }
    /**
     * Add a single Task object into the arraylist from the history.
     * @param data A Task object's string in the format for storing purpose
     */
    private static void addTask(String data) {
        String[] strings = Parser.parse(data);
        Task history;
        switch (strings[0]) {
        case "todo" -> history = addTodo(strings);
        case "deadline" -> history = addDeadline(strings);
        case "event" -> history = addEvent(strings);
        default -> {
            assert false : "shouldn't have reach here, error position: Storage.java";
            Qlin.terminate();
            return;
        }
        }
        TrackList.addTask(history);
    }
    /**
     * Return a todo object that's to be added to the tracklist.
     * @param datas The string data from the qlin.txt.
     * @return The task object to be added.
     */
    private static Task addTodo(String[] datas) {
        Task history = new Todo(datas[1]);
        if (datas[2].equals("1")) {
            history.setDone();
        }
        return history;
    }
    /**
     * Return a deadline object that's to be added to the tracklist.
     * @param datas The string data from the qlin.txt.
     * @return The task object to be added.
     */
    private static Deadline addDeadline(String[] datas) {
        Deadline history = new Deadline(datas[1], LocalDateTime.parse(datas[2], FORMATTER));
        if (datas[3].equals("1")) {
            history.setDone();
        }
        return history;
    }
    /**
     * Return an event object that's to be added to the tracklist.
     * @param datas The string data from the qlin.txt.
     * @return The task object to be added.
     */
    private static Event addEvent(String[] datas) {
        Event history = new Event(datas[1], LocalDateTime.parse(datas[2], FORMATTER),
                LocalDateTime.parse(datas[3], FORMATTER));
        if (datas[4].equals("1")) {
            history.setDone();
        }
        return history;
    }
    /**
     * Clears the qlin.txt file and the rewrite according to the tasks in the arraylist.
     * Terminates the chatbot if error is detected.
     */
    public static void store() {
        Path path = Paths.get("qlin.txt");
        // clear everything
        try {
            Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // rewrite
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Task t: TrackList.getList()) {
                String storeString = t.toStoreFormat();
                writer.write(storeString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Qlin.terminate();
        }
    }
}
