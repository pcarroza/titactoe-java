package main.controllers.local;

import main.controllers.CoordinateController;
import main.controllers.PlacementController;
import main.controllers.errors.ErrorReport;
import main.models.Coordinate;
import main.models.Game;

public abstract class LocalPlacementController extends LocalOperationController
    implements PlacementController {

    private final LocalCoordinateController coordinateController;

    public LocalPlacementController(Game game, LocalCoordinateController coordinateController) {
        super(game);
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        if (!this.hasColor(target)) {
            return this.getErrorReport(this.getGame());
        }
        return null;
    }

    abstract boolean hasColor(Coordinate target);

    abstract ErrorReport getErrorReport(Game game);

    @Override
    public CoordinateController getCoordinateController() {
        return this.coordinateController;
    }
}
