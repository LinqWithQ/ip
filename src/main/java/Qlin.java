import java.util.HashMap;
import java.util.Scanner;

public class Qlin {

    // string breaker
    private static String[] breakString(String s) {

        // special adjustment
        s = "/" + s;

        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/') {
                hashmap.put(count, i);
                count++;
            }
        }
        String[] result = new String[count];
        for (int i = 0; i < count - 1; i++) {
            int indexS = hashmap.get(i);
            int indexE = hashmap.get(i + 1);
            String sub = s.substring(indexS + 1, indexE).trim();
            result[i] = sub;
            }
        int indexS = hashmap.get(count - 1);
        String sub = s.substring(indexS + 1).trim();
        result[count - 1] = sub;
        return result;

    }

    private static void responder() throws Exception{
        Task[] tasks = new Task[101];
        int counter = 0;
        Scanner sc = new Scanner(System.in);
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

            } else if (input.startsWith("mark ")) {

                int index = Integer.parseInt(input.substring(5).trim()) - 1;
                tasks[index].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.startsWith("unmark ")) {

                int index = Integer.parseInt(input.substring(7).trim()) - 1;
                tasks[index].unDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.startsWith("todo ")) {

                Task task = new Todo(input.substring(5).trim());
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else if (input.startsWith("deadline ")) {

                String[] sub = breakString(input.substring(9).trim());
                Task task = new Deadline(sub[0], sub[1]);
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else if (input.startsWith("event ")) {

                String[] sub = breakString(input.substring(6).trim());
                Task task = new Event(sub[0], sub[1], sub[2]);
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

    public static void main(String[] args) {
        String greeting = "Hello!, I'm Qlin.\n" + "What can I do for you?\n";
        System.out.println(greeting);
        try {
            responder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return;
        }
    }
}
