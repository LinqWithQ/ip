package qlin;

import exceptions.*;

import java.util.Scanner;

public class Qlin {

    static boolean isTerminate;
    static Scanner sc;

    public static void main(String[] args) {
        System.out.println("Hello! I'm Qlin.\n" + "What can I do for you?");
        sc = new Scanner(System.in);
        isTerminate = false;
        Storage.initialize();
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
