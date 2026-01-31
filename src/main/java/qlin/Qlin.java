package qlin;

import exceptions.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Qlin {

    static boolean isTerminate;
    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Hello! I'm Qlin.\n" + "What can I do for you?");
        sc = new Scanner(System.in);
        isTerminate = false;
        if (!Files.exists(Path.of("qlin.txt"))) {
            Path path = Paths.get("qlin.txt");
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
