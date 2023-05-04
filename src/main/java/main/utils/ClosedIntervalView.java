package main.utils;

public class ClosedIntervalView {

    private final String title;

    private final ClosedInterval interval;

    public ClosedIntervalView(String title, ClosedInterval closedInterval) {
        assert title != null;
        assert closedInterval != null;
        this.title = title;
        this.interval = closedInterval;
    }

    public void writeln() {
        Terminal.getInstance().write(this.title + " " + this.toString());
    }

    @Override
    public String toString() {
        return "[" + this.interval.min() + ", " + this.interval.max() + "]";
    }
}
