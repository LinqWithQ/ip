package qlin;

import java.util.List;

public class UI {
    public static void printGreeting() {
        System.out.println("Hello! I'm Qlin.\n" + "What can I do for you?");
    }

    public static void printBye() {
        System.out.println("Goodbye, hope to not see you again!");
    }

    public static void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int x = 0; x < TrackList.size(); x++) {
            System.out.println((x + 1) + ". " + TrackList.get(x).toString());
        }
    }

    public static void printMarkTask(Task t) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + t.toString());
    }

    public static void printUnmarkTask(Task t) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("  " + t.toString());
    }

    public static void printAddTask(Task t) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + t.toString());
        System.out.println("Now you have " + TrackList.size() + " tasks in the list.");
    }

    public static void printDelete(Task t) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + t.toString());
        System.out.println("Now you have " + TrackList.size() + " tasks in the list.");
    }

    public static void printFind(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No task with such name is found.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
        }
    }

    public static void printDeleteAll() {
        System.out.println("Ok, all tasks had been deleted.");
    }
}
