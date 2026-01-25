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
}
