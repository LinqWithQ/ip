package qlin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    private final LocalDate deadlineDate;

    public Deadline(String name, LocalDate deadlineDate) {
        super(name);
        this.deadlineDate = deadlineDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadlineDate.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    @Override
    public String toStoreFormat() {
        if (this.isDone) {
            return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /1";
        } else {
            return "deadline /" + this.taskName + " /" + this.deadlineDate.toString() + " /0";
        }
    }
}
