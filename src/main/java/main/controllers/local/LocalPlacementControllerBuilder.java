package main.controllers.local;

import main.models.Game;

public abstract class LocalPlacementControllerBuilder {

    protected Game game;

    protected LocalPlacementController[] controllers;

    public LocalPlacementControllerBuilder(Game game) {
        assert game != null;
        this.game = game;
        this.controllers = new LocalPlacementController[2];
    }

    public abstract void build();

    void build(LocalCoordinateController[] localCoordinateControllers) {
        assert localCoordinateControllers != null;
        for (int i = 0; i < this.game.getNumberOfPlayers(); i++) {
            assert localCoordinateControllers[i] != null;
        }
        this.controllers[0] = new LocalPutController(game, localCoordinateControllers[0]);
        this.controllers[1] = new LocalMoveController(game, localCoordinateControllers[1]);
    }

    LocalPlacementController getPlacementController() {
        assert this.controllers != null;
        for (int i = 0; i < this.game.getNumberOfPlayers(); i++) {
            assert this.controllers[i] != null;
        }
        if (!this.game.isComplete()) {
            return this.controllers[0];
        } else {
            return this.controllers[1];
        }
    }
}
