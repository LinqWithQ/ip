package qlin;

public class Event extends Task{

    private final String beginTime;
    private final String endTime;

    public Event(String name, String beginTime, String endTime) {
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
        return "[E]" + super.toString() + " (from: " + beginTime  + " to: " + endTime + ")";
    }

    /**
     * Returns a string in a format for storing purpose
     * @return Task's string in format for qlin.txt
     */
    @Override
    public String toStoreFormat() {
        if (this.isDone) return "event /" + this.taskName + " /" + this.beginTime + " /" + this.endTime + " /1";
        return "event /" + this.taskName + " /" + this.beginTime + " /" + this.endTime + " /0";
    }
}
