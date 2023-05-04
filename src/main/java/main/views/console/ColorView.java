package main.views.console;

import main.models.Color;
import main.utils.Terminal;

public class ColorView {

    private static ColorView colorView;

    public static ColorView instance() {
        if (colorView == null) {
            colorView = new ColorView();
        }
        return colorView;
    }

    private static final char[] COLORS = {'X', 'O', '_'};

    private ColorView() {}

    void write(String title, Color color) {
        Terminal.getInstance().write(title + this.toChar(color));
    }

    void writeln(String title, Color color) {
        this.write(title, color);
        Terminal.getInstance().writeln();
    }

    void writeWinner(Color color) {
        String victory = "Victoria!!!!";
        Terminal.getInstance().write(victory);
        final int MAX = 3;
        for (int i = 0; i < MAX; i++) {
            Terminal.getInstance().write(this.toChar(color) + "! ");
        }
        Terminal.getInstance().writeln(victory);
    }

    private char toChar(Color color) {
        return COLORS[color.ordinal()];
    }
}
