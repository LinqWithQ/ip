import java.util.Scanner;

public class Qlin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Task[] tasks = new Task[101];
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
                System.out.println("Here are the tasks in your list:");

                for (int x = 0; x < counter; x++) {
                    System.out.println((x + 1) + ". " + tasks[x].toString());
                }
            } else {
                System.out.println("added: " + input);
                tasks[counter] = new Task(input);
                counter++;
            }
        }
    }
}
