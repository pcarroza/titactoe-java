package main.views.console;

import main.controllers.PlacementControllerVisitor;
import main.controllers.PlacementController;
import main.controllers.errors.ErrorReport;
import main.controllers.MoveController;
import main.controllers.PutController;
import main.models.Coordinate;
import main.models.Color;

public class GameView implements PlacementControllerVisitor {

    private final BoardView boardView;

    private final ErrorReportView errorReportView;

    private Coordinate origin;

    public GameView(BoardView boardView) {
        assert boardView != null;
        this.boardView = boardView;
        this.errorReportView = new ErrorReportView();
    }

    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(PutController put) {
        this.showTitle("Pone ", put.take());
        this.put(put, new PutTargetCoordinateView(put.getCoordinateController()));
        this.showGame(put);
    }

    @Override
    public void visit(MoveController move) {
        this.showTitle("Move", move.take());
        this.remove(move, new MoveOriginCoordinateView(move.getCoordinateController()));
        this.put(move, new MoveOriginCoordinateView(move.getCoordinateController()));
        this.showGame(move);
    }

    private void showTitle(String title, Color color) {
        ColorView.instance().writeln(title + "el jugador ", color);
    }

    private void put(PutController putController, PlacementCoordinateView placementCoordinateView) {
        Coordinate target;
        ErrorReport errorReport;
        do {
            target = placementCoordinateView.getCoordinate();
            errorReport = putController.validateTarget(target);
            if (errorReport != null) {
                errorReportView.write(errorReport);
            }
        } while (errorReport != null);
        putController.put(target);
    }

    private void put(MoveController moveController, PlacementCoordinateView placementCoordinateView) {
        Coordinate target;
        ErrorReport errorReport = null;
        do {
            target = placementCoordinateView.getCoordinate();
            errorReport = moveController.validateTarget(this.origin, target);
            if (errorReport != null) {
                errorReportView.write(errorReport);
            }
        } while (errorReport != null);
        moveController.put(target);
    }

    private void remove(MoveController moveController, PlacementCoordinateView placementCoordinateView) {
        ErrorReport errorReport = null;
        do {
            origin = placementCoordinateView.getCoordinate();
            errorReport = moveController.validateOrigin(origin);
            if (errorReport != null) {
                errorReportView.write(errorReport);
            }
        } while (errorReport != null);
        moveController.remove(origin);
    }

    private void showGame(PlacementController placementController) {
        this.boardView.write(placementController);
        if (placementController.isExistTicTacToe()) {
            ColorView.instance().writeWinner(placementController.take());
        }
    }
}
