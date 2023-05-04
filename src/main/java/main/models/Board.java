package main.models;

import main.utils.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Board extends Subject {

    private final Map<Color, Set<Coordinate>> flat;

    private Turn turn;

    private boolean existTicTacToe;

    private static final int NUMBER_OF_PLAYERS = 2;

    public Board() {
        this.flat = new HashMap<>();
        this.turn = new Turn();
        this.createFlat(this.turn.currentPlayer());
        this.existTicTacToe = false;
    }

    private void createFlat(int currentPlayer) {
        if (currentPlayer < Board.NUMBER_OF_PLAYERS) {
            this.flat.put(Color.values()[currentPlayer], new HashSet<Coordinate>());
            this.createFlat(currentPlayer + 1);
        }
    }

    void put(Coordinate coordinate) {
        assert coordinate != null;
        this.flat.get(this.turn.take()).add(coordinate.copy());
    }

    public int getNumberOfPlayers() {
        return Board.NUMBER_OF_PLAYERS;
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        Color color_ = Color.NONE;
        for (Color color : this.flat.keySet()) {
            if (this.flat.get(color).contains(coordinate)) {
                color_ = color;
            }
        }
        return color_;
    }

    public boolean isComplete() {
        int numberOfTokens = this.flat.keySet()
                .stream()
                .mapToInt(color -> this.flat.get(color).size())
                .sum();
        return numberOfTokens == Coordinate.DIMENSION * this.flat.keySet().size();
    }

    public Color take() {
        return this.turn.take();
    }

    public int currentPlayer() {
        return this.turn.currentPlayer();
    }

    public void changeTurn() {
        this.turn.changeTurn();
    }

    public boolean isExistTicTacToe() {
        Set<Coordinate> coordinates = this.flat.get(this.turn.take());
        if (coordinates.size() != Coordinate.DIMENSION) {
            return false;
        }
        Coordinate[] coordinatesArray = coordinates.toArray(new Coordinate[0]);
        Direction direction = coordinatesArray[0].inDirection(coordinatesArray[1]);
        if (direction == Direction.NON_EXISTENT) {
            return false;
        }
        for (int i = 1; i < Coordinate.DIMENSION - 1; i++) {
            if (coordinatesArray[i].inDirection(coordinatesArray[i + 1]) != direction) {
                return false;
            }
        }
        return true;
    }

    boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return !this.flat.get(Color.OS).contains(coordinate) && !this.flat.get(Color.XS).contains(coordinate);
    }

    boolean isOccupiedByPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return this.flat.get(this.turn.take()).contains(coordinate);
    }

    void clear() {
        this.flat.keySet().forEach(color -> this.flat.get(color).clear());
        this.existTicTacToe = false;
    }

    public void remove(Coordinate origin) {
        this.flat.get(this.turn.take()).remove(origin);
    }

    public List<Coordinate> getEmptyCoordinates() {
        return this.getCoordinates(coordinate -> this.getColor(coordinate) == Color.NONE);
    }

    public List<Coordinate> getPlayerCoordinates() {
        return this.getCoordinates(coordinate -> this.getColor(coordinate) == this.turn.take());
    }

    private @NotNull List<Coordinate> getCoordinates(Comparator comparator) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                if (comparator.isEqualsColor(coordinate)) {
                    coordinates.add(coordinate);
                }
            }
        }
        return coordinates;
    }

    @Override
    public String toString() {
        return " " + this.flat;
    }

    public static void main(String[] args) {

        Board board = new Board();
        board.put(new Coordinate(1,1));
        board.put(new Coordinate(1,2));
        board.put(new Coordinate(1,3));

        System.out.println(board.getEmptyCoordinates());
        System.out.println(board.getPlayerCoordinates());

        System.out.println(board.getColor(new Coordinate(1,2)));

    }
}




