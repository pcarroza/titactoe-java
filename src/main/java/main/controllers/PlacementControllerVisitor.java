package main.controllers;

import main.models.Coordinate;

public interface PlacementControllerVisitor {

    void visit(PutController putController);

    void visit(MoveController moveController);
}
