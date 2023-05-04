package main.utils;

import java.util.Objects;

public class Coordinate {

    private int row;

    private int column;

    public Coordinate() {
        this.row = 0;
        this.column = 0;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return this.column;
    }

    public int getRow() {
        return this.row;
    }

    public Direction direction(Coordinate coordinate) {
        return null;
    }

    @Override
    public String toString() {
        return "Coordinate(" + this.row + ", " + this.column + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
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
        if (column != other.getColumn())
            return false;
        return row == other.getRow();
    }
}
