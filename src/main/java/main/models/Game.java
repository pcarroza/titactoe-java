package main.models;

import java.util.List;

public class Game {

    private final Board board;

    public Game(Observer observer) {
        this.board = new Board();
        this.board.subscribe(observer);
    }

    public void put(Coordinate target) {
        this.board.put(target);
    }

    public void remove(Coordinate origin) {
        this.board.remove(origin);
    }

    public Color take() {
        return this.board.take();
    }

    public int currentPlayer() {
        return this.board.currentPlayer();
    }

    public void change() {
        this.board.changeTurn();
    }

    public boolean isOccupiedByPlayer(Coordinate origin) {
        return this.board.isOccupiedByPlayer(origin);
    }

    public boolean isEmpty(Coordinate target) {
        return this.board.isEmpty(target);
    }

    public int getNumberOfPlayers() {
        return this.board.getNumberOfPlayers();
    }

    public void clear() {
        this.board.clear();
    }

    public boolean isComplete() {
        return this.board.isComplete();
    }

    public boolean isExistTicTacToe() {
        return this.board.isExistTicTacToe();
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public List<Coordinate> emptyCoordinates() {
        return this.board.getEmptyCoordinates();
    }

    public List<Coordinate> playerCoordinates() {
        return this.board.getPlayerCoordinates();
    }

    public void initialize() {
        this.board.initialize();
    }

    public void begin() {
        this.board.begin();
    }
    
    public void end() {
        this.board.end();
    }

    public void exit() {
        this.board.exit();
    }
}
