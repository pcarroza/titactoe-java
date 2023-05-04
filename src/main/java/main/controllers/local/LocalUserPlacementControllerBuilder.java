package main.controllers.local;

import main.models.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    public LocalUserPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void build() {
        LocalCoordinateController[] localCoordinateController = {
                new LocalUserCoordinateController(this.game),
                new LocalUserCoordinateController(this.game)
        };
        this.build(localCoordinateController);
    }
}
