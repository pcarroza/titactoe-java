package main.models;

import java.util.List;

public interface Flat {

    void put(Coordinate target);

    void remove(Coordinate origin);

    Color take();

    void changeTurn();

    boolean isFull(Coordinate orign);

    boolean isEmpty(Coordinate target);

    int getNumberOfPlayers();

    void clear();

    boolean isComplete();

    boolean isExistTicTacToe();

    Color getColor(Coordinate coordinate);

    List<Coordinate> emptyCoordinates();

    List<Coordinate> playerCoordinates();
}
