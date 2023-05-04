package main.controllers;

import main.controllers.errors.ErrorReport;
import main.models.Coordinate;

public interface PutController extends PlacementController {

    ErrorReport validateTarget(Coordinate target);

}

