import java.util.Scanner;

public class Qlin {
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        Scanner sc = new Scanner(System.in);

        String[] store = new String[101];
        int counter = 0;

        String greeting = "Hello!, I'm Qlin.\n"
            + "What can I do for you?\n";

        System.out.println(greeting);

        boolean terminate = false;
        while (!terminate) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Goodbye, hope to not see you again!");
                terminate = true;
            } else if (input.equals("list")) {
                for (int x = 0; x < counter; x++) {
                    System.out.println((x + 1) + ". " + store[x]);
                }
            } else {
                System.out.println("added: " + input);
                store[counter] = input;
                counter++;
            }
        }
    }
}
