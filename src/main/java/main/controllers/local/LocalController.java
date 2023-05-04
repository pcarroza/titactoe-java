package main.controllers.local;

import main.models.Coordinate;
import main.models.Color;
import main.models.Game;

public class LocalController {

    private final Game game;

    protected LocalController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected Game getGame() {
        return this.game;
    }

    protected int getNumberOfPlayers() {
        return this.game.getNumberOfPlayers();
    }

    public Color take() {
        return this.game.take();
    }

    public void put(Coordinate target) {
        assert target != null;
        this.game.put(target);
    }

    public void remove(Coordinate origin) {
        assert origin != null;
        this.game.remove(origin);
    }

    public void clear() {
        this.game.clear();
    }

    public boolean isExistTicTacToe() {
        return this.game.isExistTicTacToe();
    }

    public void change() {
        this.game.change();
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return this.game.isEmpty(coordinate);
    }

    public boolean isOccupiedByPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return this.game.isOccupiedByPlayer(coordinate);
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.game.getColor(coordinate);
    }

    public void initialize() {
        this.game.initialize();
    }

    public void end() {
        this.game.end();
    }

    public void begin() {
        this.game.begin();
    }

    public void exit() {
        this.game.exit();
    }
}
