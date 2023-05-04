package main.controllers;

import main.controllers.errors.ErrorReport;
import main.models.Coordinate;

public interface MoveController extends PlacementController {

    ErrorReport validateOrigin(Coordinate origin);

    void remove(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
