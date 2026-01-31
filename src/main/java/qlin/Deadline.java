package qlin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    private final LocalDate deadlineDate;

    public Deadline(String name, LocalDate deadlineDate) {
        super(name);
        this.deadlineDate = deadlineDate;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI
     * @return Task's string in format for UI
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadlineDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    @Override
    public String toStoreFormat() {
        if (this.isDone) return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /1";
        return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /0";
    }
}
