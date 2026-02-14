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
     * Setups the scanner object and isTerminate boolean object.
     * If no such file is found, then create a new file.
     */
    public static void initialize() {
        TrackList.deleteAll();
        Path path = Path.of("qlin.txt");
        if (!Files.exists(path)) {
            createFile(path);
        } else {
            rebuildTracklist();
        }
    }

    /**
     * Creates a local file "qlin.txt" for storing data.
     * Terminates the chatbot if error is detected.
     * @param path The location of the file.
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
     * Abstract method for rebuilding the TrackList.
     * Terminates the chatbot if error is detected.
     */
    private static void rebuildTracklist() {
        try {
            Scanner sc = new Scanner(new File("qlin.txt"));
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
     * Concreate method for adding task object into TrackList.
     * Add a single Task object into the arraylist from the history.
     * @param s A Task object's string in the format for storing purpose
     */
    private static void addTask(String s) {
        String[] strings = Parser.parse(s);
        Task history;
        switch (strings[0]) {
        case "task" -> {
            history = new Task(strings[1]);
            if (strings[2].equals("1")) {
                history.setDone();
            }
        }
        case "todo" -> {
            history = new Todo(strings[1]);
            if (strings[2].equals("1")) {
                history.setDone();
            }
        }
        case "deadline" -> {
            history = new Deadline(strings[1], LocalDateTime.parse(strings[2], FORMATTER));
            if (strings[3].equals("1")) {
                history.setDone();
            }
        }
        default -> {
            history = new Event(strings[1], LocalDateTime.parse(strings[2], FORMATTER),
                    LocalDateTime.parse(strings[3], FORMATTER));
            if (strings[4].equals("1")) {
                history.setDone();
            }
        }
        }
        TrackList.addTask(history);
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
