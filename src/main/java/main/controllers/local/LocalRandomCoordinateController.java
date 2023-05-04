package main.controllers.local;

import main.controllers.CoordinateControllerVisitor;
import main.controllers.RandomCoordinateController;
import main.models.Coordinate;
import main.models.Game;

public class LocalRandomCoordinateController extends LocalCoordinateController
    implements RandomCoordinateController {

    public LocalRandomCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        Coordinate origin = new Coordinate();
        boolean isOccupiedByPlayer;
        do {
            origin.random();
            isOccupiedByPlayer = this.isOccupiedByPlayer(origin);
        } while (!isOccupiedByPlayer);
        return origin;
    }

    @Override
    public Coordinate getTarget() {
        Coordinate target = new Coordinate();
        boolean isEmpty;
        do {
            target.random();
            isEmpty = this.isEmpty(target);
        } while (!isEmpty);
        return target;
    }

    @Override
    public Coordinate getTarget(Coordinate origin) {
        assert origin != null;
        Coordinate target;
        boolean isEquals;
        do {
            target = this.getTarget();
            isEquals = !origin.equals(target);
        } while (!isEquals);
        return target;
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }

}

