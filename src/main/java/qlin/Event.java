package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    private final LocalDateTime beginTime;
    private final LocalDateTime endTime;

    public Event(String name, LocalDateTime beginTime, LocalDateTime endTime) {
        super(name);
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI
     * @return Task's string in format for UI
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + beginTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"))
                + " to: " + endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")) + ")";
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    @Override
    public String toStoreFormat() {
        if (this.isDone) {
            return "event /" + this.taskName + " /" + this.beginTime.toString() + " /" + this.endTime.toString() + " /1";
        } else {
            return "event /" + this.taskName + " /" + this.beginTime.toString() + " /" + this.endTime.toString() + " /0";
        }
    }
}
