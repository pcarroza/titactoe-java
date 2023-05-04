package main.models;

public class Turn {

    private int value = 0;

    public Turn() {
        this.value = 0;
    }

    public Color take() {
        return Color.values()[value];
    }

    public int currentPlayer() {
        return this.take().ordinal();
    }

    public void changeTurn() {
        this.value = (value + 1) % (Color.values().length - 1);
    }
}
