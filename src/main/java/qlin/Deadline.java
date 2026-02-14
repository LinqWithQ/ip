package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The class that represent deadline tasks.
 */
public class Deadline extends Task {

    private final LocalDateTime deadlineDate;

    /**
     * The method for create a deadline task object.
     * @param name Deadline's name.
     * @param dateTime The deadline time in the format of "yyyy-MM-dd'T'HH:mm".
     */
    public Deadline(String name, LocalDateTime dateTime) {
        super(name);
        assert dateTime != null : "time shouldn't be null";
        this.deadlineDate = dateTime;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI.
     * @return Task's string in format for UI.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: "
                + this.deadlineDate.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")) + ")";
    }

    /**
     * Returns a string in a format for storing purpose.
     * @return Task's string in format for qlin.txt.
     */
    @Override
    public String toStoreFormat() {
        if (this.isDone) {
            return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /1";
        } else {
            return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /0";
        }
    }
}
