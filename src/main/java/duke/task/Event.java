package duke.task;

public class Event extends Task {
    private String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
        this.type = "E";
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + at + ")";
    }
}