package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.PlacementControllerVisitor;
import main.controllers.errors.ErrorReport;
import main.controllers.MoveController;
import main.controllers.errors.ErrorGeneratorType;
import main.models.Coordinate;
import main.models.Game;

public class LocalMoveController extends LocalPlacementController
    implements MoveController {

    private Coordinate origin;

    LocalMoveController(Game game, LocalCoordinateController coordinateController) {
        super(game, coordinateController);
    }

    @Override
    public void remove(Coordinate origin) {
        assert origin != null;
        assert this.validateOrigin(origin) == null;
        this.origin = origin;
        super.remove(origin);
    }

    @Override
    public ErrorReport validateOrigin(Coordinate origin) {
        assert origin != null;
        return super.validateTarget(origin);
    }

    @Override
    boolean hasColor(Coordinate target) {
        return this.isOccupiedByPlayer(origin);
    }

    @Override
    ErrorReport getErrorReport(Game game) {
        return ErrorGeneratorType.NOT_PROPERTY.getErrorReport(this.getGame());
    }

    @Override
    public void put(Coordinate target) {
        assert target != null;
        assert origin != null;
        assert this.validateTarget(origin, target) == null;
        super.put(target);
        origin = null;
    }

    @Override
    public ErrorReport validateTarget(Coordinate origin, Coordinate target) {
        ErrorReport errorReport = super.validateTarget(target);
        if (errorReport != null) {
            return errorReport;
        }
        if (origin.equals(target)) {
            return ErrorGeneratorType.REPEATED_COORDINATE.getErrorReport(this.getGame());
        }
        return null;
    }

    @Override
    public boolean isExistTicTacToe() {
        return super.isExistTicTacToe();
    }

    @Override
    public void accept(PlacementControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }
}
