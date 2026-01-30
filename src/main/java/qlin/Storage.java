package qlin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Storage {

    public static void initialize() throws IOException {
        Scanner sc = new Scanner(new File("data/qlin.txt"));
        while (sc.hasNextLine()) {
            buildArrayList(sc.nextLine());
        }
        sc.close();
    }

    public static void buildArrayList(String s) {
        String[] strings = Parser.breakString(s);
        Task history;
        if (strings[0].equals("task")) {
            history = new Task(strings[1]);
            if (strings[2].equals("1")) history.setDone();
        } else if (strings[0].equals("todo")) {
            history = new Todo(strings[1]);
            if (strings[2].equals("1")) history.setDone();
        } else if (strings[0].equals("deadline")) {
            history = new Deadline(strings[1], LocalDate.parse(strings[2]));
            if (strings[3].equals("1")) history.setDone();
        } else {
            history = new Event(strings[1], strings[2], strings[3]);
            if (strings[4].equals("1")) history.setDone();
        }
        TrackList.add(history);
    }

    public static void store() {
        Path path = Paths.get("data/qlin.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Task t: TrackList.getList()) {
                String storeString = t.toStoreFormat();
                writer.write(storeString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
