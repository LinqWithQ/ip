import java.util.HashMap;
import java.util.Scanner;

public class Qlin {

    static boolean terminate = false;
    static Task[] tasks = new Task[101];
    static Integer counter = 0;

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

    private static void responder() throws QlinException{

        Scanner sc = new Scanner(System.in);
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

            } else if (input.equals("mark") || input.startsWith("mark ")) {

                if (input.equals("mark")) throw new InvalidMarkException();
                String check = input.substring(5).trim();
                if (check.isEmpty()) throw new InvalidMarkException();
                int index = Integer.parseInt(check) - 1;
                tasks[index].setDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.equals("unmark") || input.startsWith("unmark ")) {
                
                if (input.equals("unmark")) throw new InvalidUnmarkException();
                String check = input.substring(7).trim();
                if (check.isEmpty()) throw new InvalidUnmarkException();
                int index = Integer.parseInt(check) - 1;
                tasks[index].unDone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("  " + tasks[index].toString());

            } else if (input.startsWith("todo ")) {

                String check = input.substring(5).trim();
                Task task = new Todo(check);
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else if (input.startsWith("deadline ")) {

                String check = input.substring(9).trim();
                String[] sub = breakString(check);
                Task task = new Deadline(sub[0], sub[1]);
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else if (input.startsWith("event ")) {

                String check = input.substring(6).trim();
                String[] sub = breakString(check);
                Task task = new Event(sub[0], sub[1], sub[2]);
                tasks[counter] = task;
                counter++;
                System.out.println("Got it. I've added this task:");
                System.out.println("  " + task.toString());
                System.out.println("Now you have " + counter + " tasks in the list.");

            } else {

                throw new InvalidInputException();

            }

        }
        return;

    }

    public static void main(String[] args) {

        System.out.println("Hello!, I'm Qlin.\n" + "What can I do for you?\n");
        while (!terminate) {

            try {
                responder();
            } catch (InvalidMarkException e) {
                e.echo();
            }

            catch (InvalidTodoException e) {
                e.echo();
            } catch (InvalidUnmarkException e) {
                e.echo();
            } catch (InvalidDeadlineException e) {
                e.echo();
            } catch (InvalidEventException e ) {
                e.echo();
            } catch (InvalidInputException e) {
                e.echo();
            } catch (Exception e) {}

        }
        return;

    }
}
