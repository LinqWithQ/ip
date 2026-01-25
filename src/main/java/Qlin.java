import java.util.Scanner;

public class Qlin {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[101];
        int counter = 0;
        String greeting = "Hello!, I'm Qlin.\n" + "What can I do for you?\n";
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

            } else if (input.startsWith("mark")) {

                int index = Integer.parseInt(input.substring(4).trim());
                tasks[index - 1].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.startsWith("unmark")) {

                int index = Integer.parseInt(input.substring(6).trim());
                tasks[index - 1].unDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.startsWith("todo")) {

                Task task = new Todo(input.substring(5));
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else {

                System.out.println("added: " + input);
                tasks[counter] = new Task(input);
                counter++;

            }
        }
    }
}
