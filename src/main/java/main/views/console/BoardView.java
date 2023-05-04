package main.views.console;

import main.controllers.PresenterController;
import main.models.Coordinate;
import main.utils.Terminal;

public class BoardView {

    void write(PresenterController presenter) {
        assert presenter != null;
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                ColorView.instance().write(" ", presenter.getColor(new Coordinate(i,j)));
            }
            Terminal.getInstance().writeln();
        }
    }
}
