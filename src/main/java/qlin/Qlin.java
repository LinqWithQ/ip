package qlin;

import exceptions.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

public class Qlin {

    static boolean isTerminate = false;

    public static void main(String[] args) {
        System.out.println("Hello!, I'm Qlin.\n" + "What can I do for you?\n");
        if (!Files.exists(Path.of("data/qlin.txt"))) {
            Path path = Paths.get("data/qlin.txt");
            try {
                Files.createFile(path);
            } catch (IOException e) {
                System.err.println("Could not create file: " + e.getMessage());
            }
        } else {
            try {
                Storage.initialize();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        while (!isTerminate) {
            try {
                Responder.respond();
            } catch (QlinException e) {
                e.echo();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        Storage.store();
    }
}
