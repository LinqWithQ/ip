package qlin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The class that represent Event tasks.
 */
public class Event extends Task {

    private final LocalDateTime beginTime;
    private final LocalDateTime endTime;
    private String location = null;

    /**
     * Return an Event object.
     * @param name Event's name.
     * @param beginTime The event starting time in the format of "yyyy-MM-dd'T'HH:mm".
     * @param endTime The event ending time in the format of "yyyy-MM-dd'T'HH:mm".
     */
    public Event(String name, LocalDateTime beginTime, LocalDateTime endTime) {
        super(name);
        assert beginTime != null && endTime != null : "time shouldn't be null";
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    /**
     * Return an Event object.
     * @param name Event's name.
     * @param beginTime The event starting time in the format of "yyyy-MM-dd'T'HH:mm".
     * @param endTime The event ending time in the format of "yyyy-MM-dd'T'HH:mm".
     * @param location The location of the event in the format of string.
     */
    public Event(String name, LocalDateTime beginTime, LocalDateTime endTime, String location) {
        super(name);
        assert beginTime != null && endTime != null : "time shouldn't be null";
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }

    /**
     * Returns a string in a format that is meant to be shown in the UI
     * @return Task's string in format for UI
     */
    @Override
    public String toString() {
        String result = "[E]" + super.toString() + " (from: "
                + beginTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"))
                + " to: " + endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"));
        if (this.location != null) {
            result += (", location: " + this.location);
        }
        result += ")";
        return result;
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    @Override
    public String toStoreFormat() {
        String result;
        result = "event /" + this.taskName
                + " /" + this.beginTime.toString()
                + " /" + this.endTime.toString();
        if (this.location != null) {
            result += (" /" + this.location);
        }
        if (this.isDone) {
            result += (" /1");
        } else {
            result += (" /0");
        }
        return result;
    }
}
