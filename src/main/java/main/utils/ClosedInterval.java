package main.utils;

public record ClosedInterval(int min, int max) {
    public boolean includes(int value) {
        return this.min <= value && value <= this.max;
    }
}
