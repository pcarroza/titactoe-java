package main.models;

import main.utils.ClosedInterval;
import main.utils.Direction;

import java.util.Random;

public class Coordinate {

    private final main.utils.Coordinate coordinate;

    public static final int DIMENSION = 3;

    public Coordinate() {
        this.coordinate = new main.utils.Coordinate();
    }

    public Coordinate(int row, int column) {
        this();
        this.setRow(row);
        this.setColumn(column);
    }

    public int getColumn() {
        return this.coordinate.getColumn();
    }

    public int getRow() {
        return this.coordinate.getRow();
    }

    public void setColumn(int column) {
        assert new ClosedInterval(1, Coordinate.DIMENSION).includes(column);
        this.coordinate.setColumn(column);
    }

    public void setRow(int row) {
        assert new ClosedInterval(1, Coordinate.DIMENSION).includes(row);
        this.coordinate.setRow(row);
    }

    public Coordinate copy() {
        return new Coordinate(this.getRow(), this.getColumn());
    }

    public void random() {
        Random random = new Random(System.currentTimeMillis());
        coordinate.setRow(random.nextInt(Coordinate.DIMENSION));
        coordinate.setColumn(random.nextInt(Coordinate.DIMENSION));
    }

    public Direction inDirection(Coordinate coordinate) {
        Direction direction = this.coordinate.direction(coordinate.coordinate);
        if (direction == Direction.NON_EXISTENT) {
            if (this.inInverse() && coordinate.inInverse()) {
                return Direction.INVERSE;
            }
        }
        return direction;
    }

    private boolean inInverse() {
        return this.coordinate.getRow() + this.coordinate.getColumn() == Coordinate.DIMENSION;
    }

    @Override
    public String toString() {
        return this.coordinate.toString();
    }


    @Override
    public int hashCode() {
        return this.coordinate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (coordinate == null) {
            return other.coordinate == null;
        } else {
            return coordinate.equals(other.coordinate);
        }
    }

    public static void main(String[] args) {

    }
}
