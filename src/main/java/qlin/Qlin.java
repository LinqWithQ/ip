package qlin;

import exceptions.*;

import java.util.Scanner;

public class Qlin {

    static boolean isTerminate;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        isTerminate = false;
        UI.printGreeting();
        Storage.initialize();
        while (!isTerminate) {
            try {
                Processer.process();
            } catch (QlinException e) {
                e.echo();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isTerminate = true;
            }
        }
        Storage.store();
    }
}
