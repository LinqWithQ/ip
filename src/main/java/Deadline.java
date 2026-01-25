public class Deadline extends Task{

    private final String deadlineDate;

    public Deadline(String name, String deadlineDate) {
        super(name);
        this.deadlineDate = deadlineDate;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadlineDate + ")";
    }
}
