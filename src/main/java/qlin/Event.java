package qlin;

public class Event extends Task{

    private final String beginTime;
    private final String endTime;

    public Event(String name, String beginTime, String endTime) {
        super(name);
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + beginTime  + " to: " + endTime + ")";
    }

    @Override
    public String toStoreFormat() {
        if (this.isDone) {
            return "event /" + this.taskName + " /" + this.beginTime + " /" + this.endTime + " /1";
        } else {
            return "event /" + this.taskName + " /" + this.beginTime + " /" + this.endTime + " /0";
        }
    }
}
