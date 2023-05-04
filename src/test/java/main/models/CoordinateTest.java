package main.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoordinateTest {

    @Test
    void isEqualCoordinates() {
        assertEquals(new Coordinate(1,2), new Coordinate(1,2));
    }

}

