package qlin;

import exceptions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskFactory {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static Task createTask(String[] inputs) throws QlinException {
        Task t = null;
        try {
            switch (inputs[0]) {
                case "todo" -> {
                    if (inputs.length == 1) {
                        throw new InvalidTodoException();
                    } else {
                        t = new Todo(inputs[1]);
                    }
                }
                case "deadline" -> {
                    if (inputs.length <= 2) {
                        throw new InvalidDeadlineException();
                    } else {
                        LocalDateTime dateTime;
                        try {
                            dateTime = LocalDateTime.parse(inputs[2], FORMATTER);
                        } catch (DateTimeParseException e) {
                            throw new InvalidDateTimeException();
                        }
                        t = new Deadline(inputs[1], dateTime);
                    }
                }
                case "event" -> {
                    if (inputs.length <= 3) {
                        throw new InvalidEventException();
                    } else {
                        LocalDateTime dateTime1;
                        LocalDateTime dateTime2;
                        try {
                            dateTime1 = LocalDateTime.parse(inputs[2], FORMATTER);
                            dateTime2 = LocalDateTime.parse(inputs[3], FORMATTER);
                        } catch (DateTimeParseException e) {
                            throw new InvalidDateTimeException();
                        }
                        t = new Event(inputs[1], dateTime1, dateTime2);
                    }
                }
            }
        } catch (QlinException e) {
            e.echo();
        }
        return t;
    }
}
