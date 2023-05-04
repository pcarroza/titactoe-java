package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.PlacementControllerVisitor;
import main.controllers.errors.ErrorGeneratorType;
import main.controllers.errors.ErrorReport;
import main.controllers.PutController;
import main.models.Coordinate;
import main.models.Game;

public class LocalPutController extends LocalPlacementController
    implements PutController {

    LocalPutController(Game game, LocalCoordinateController coordinateController) {
        super(game, coordinateController);
    }

    @Override
    public void put(Coordinate target) {
        assert this.validateTarget(target) == null;
        super.put(target);
        if (!this.isExistTicTacToe()) {
            this.change();
        }
    }

    @Override
    public boolean isExistTicTacToe() {
        return super.isExistTicTacToe();
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        return super.validateTarget(target);
    }

    @Override
    boolean hasColor(Coordinate target) {
        return this.isEmpty(target);
    }

    @Override
    ErrorReport getErrorReport(Game game) {
        return ErrorGeneratorType.NOT_EMPTY.getErrorReport(this.getGame());
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
