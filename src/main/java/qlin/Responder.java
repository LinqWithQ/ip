package qlin;

import exceptions.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Responder {
    public Responder() {

    }

    public static void respond() throws QlinException {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.equals("bye")) {

            System.out.println("Goodbye, hope to not see you again!");
            Qlin.isTerminate = true;

        } else if (input.equals("list")) {

            System.out.println("Here are the tasks in your list:");
            for (int x = 0; x < TrackList.getLen(); x++) {
                System.out.println((x + 1) + ". " + TrackList.get(x).toString());
            }

        } else if (input.equals("mark") || input.startsWith("mark ")) {

            if (input.equals("mark")) throw new InvalidMarkException();
            String check = input.substring(5).trim();
            if (check.isEmpty()) throw new InvalidMarkException();
            if (TrackList.getLen() == 0) throw new NoElementException();
            int index = Integer.parseInt(check) - 1;
            if (index >= TrackList.getLen()) throw new InvalidIndexException(TrackList.getLen());
            TrackList.get(index).setDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("  " + TrackList.get(index).toString());

        } else if (input.equals("unmark") || input.startsWith("unmark ")) {

            if (input.equals("unmark")) throw new InvalidUnmarkException();
            String check = input.substring(7).trim();
            if (check.isEmpty()) throw new InvalidUnmarkException();
            if (TrackList.getLen() == 0) throw new NoElementException();
            int index = Integer.parseInt(check) - 1;
            if (index >= TrackList.getLen()) throw new InvalidIndexException(TrackList.getLen());
            TrackList.get(index).unDone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println("  " + TrackList.get(index).toString());

        } else if (input.equals("todo") || input.startsWith("todo ")) {

            if (input.equals("todo")) throw new InvalidTodoException();
            String check = input.substring(5).trim();
            if (check.isEmpty()) throw new InvalidTodoException();
            Task task = new Todo(check);
            TrackList.add(task);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + task.toString());
            System.out.println("Now you have " + TrackList.getLen() + " tasks in the list.");

        } else if (input.equals("deadline") || input.startsWith("deadline ")) {

            if (input.equals("deadline")) throw new InvalidDeadlineException();
            String check = input.substring(9).trim();
            String[] sub = Parser.breakString(check);
            if (sub.length == 0 || sub.length > 2) throw new InvalidDeadlineException();
            if (sub.length == 1) throw new InvalidDeadlineTimeException();
            LocalDate deadline = null;
            try {
                deadline = LocalDate.parse(sub[1]);
            } catch (DateTimeParseException e) {
                throw new QlinException("Sry, the date format is invalid, pls follow this format: \"yyyy-mm-dd\"");
            }
            Task task = new Deadline(sub[0], deadline);
            TrackList.add(task);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + task.toString());
            System.out.println("Now you have " + TrackList.getLen() + " tasks in the list.");

        } else if (input.equals("event") || input.startsWith("event ")) {

            if (input.equals("event")) throw new InvalidEventException();
            String check = input.substring(6).trim();
            String[] sub = Parser.breakString(check);
            if (sub.length != 3) throw new InvalidEventException();
            Task task = new Event(sub[0], sub[1], sub[2]);
            TrackList.add(task);
            System.out.println("Got it. I've added this task:");
            System.out.println("  " + task.toString());
            System.out.println("Now you have " + TrackList.getLen() + " tasks in the list.");

        } else if (input.equals("delete") || input.startsWith("delete ")) {
            if (input.equals("delete")) throw new InvalidDeleteException();
            //special command
            if (input.equals("delete all")) {
                TrackList.deleteAll();
                System.out.println("Ok, all tasks are deleted.");
                return;
            }
            String check = input.substring(7).trim();
            if (check.isEmpty()) throw new InvalidDeleteException();
            if (TrackList.getLen() == 0) throw new NoElementException();
            int index = Integer.parseInt(check) - 1;
            if (index >= TrackList.getLen()) throw new InvalidIndexException(TrackList.getLen());
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + TrackList.get(index).toString());
            System.out.println("Now you have " + TrackList.getLen() + " tasks in the list.");
            TrackList.delete(index);

        } else {
            throw new InvalidInputException();
        }
        return;

    }
}
