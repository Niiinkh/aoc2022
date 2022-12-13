package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {

    @Test
    void coordinatesAreEqualIfXAndYAreEqual() {
        Coordinates coordinatesA = Coordinates.of(12, 7);
        Coordinates coordinatesB = Coordinates.of(12, 7);
        assertThat(coordinatesA).isEqualTo(coordinatesB);
    }

    @Test
    void coordinatesAreNotEqualIfXDiffers() {
        Coordinates coordinatesA = Coordinates.of(11, 7);
        Coordinates coordinatesB = Coordinates.of(12, 7);
        assertThat(coordinatesA).isNotEqualTo(coordinatesB);
    }


    @Test
    void coordinatesAreNotEqualIfYDiffers() {
        Coordinates coordinatesA = Coordinates.of(12, 7);
        Coordinates coordinatesB = Coordinates.of(12, -7);
        assertThat(coordinatesA).isNotEqualTo(coordinatesB);
    }

    @Test
    void oldCoordinatesAreNotChanged() {
        Coordinates coordinates = Coordinates.of(12, 7);
        Coordinates delta = Coordinates.from(coordinates, -5, 3);
        assertThat(coordinates).isEqualTo(Coordinates.of(12, 7));
    }

    @Test
    void newCoordinatesApplyDeltaCorrectly() {
        Coordinates coordinates = Coordinates.of(12, 7);
        Coordinates newCoordinates = Coordinates.from(coordinates, -2, 3);
        assertThat(newCoordinates).isEqualTo(Coordinates.of(10, 10));
    }

    @Test
    void deltaIsZero() {
        Coordinates coordinates = Coordinates.of(5, 5);
        assertThat(coordinates.delta(coordinates)).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void deltaCalculationsDependOnWhoIsCallingWho() {
        Coordinates coordinatesA = Coordinates.of(5, 5);
        Coordinates coordinatesB = Coordinates.of(7, -1);
        assertThat(coordinatesA.delta(coordinatesB)).isEqualTo(Coordinates.of(2, -6));
        assertThat(coordinatesB.delta(coordinatesA)).isEqualTo(Coordinates.of(-2, 6));
    }

    @Test
    void distanceIsZero() {
        Coordinates coordinates = Coordinates.of(5, 5);
        assertThat(coordinates.distance(coordinates)).isEqualTo(0);
    }

    @Test
    void distanceOne() {
        Coordinates coordinatesA = Coordinates.of(5, 5);
        Coordinates coordinatesB = Coordinates.of(4, 5);
        assertThat(coordinatesA.distance(coordinatesB)).isEqualTo(1);
        assertThat(coordinatesB.distance(coordinatesA)).isEqualTo(1);
    }

    @Test
    void distanceTwo() {
        Coordinates coordinatesA = Coordinates.of(5, 5);
        Coordinates coordinatesB = Coordinates.of(3, 5);
        assertThat(coordinatesA.distance(coordinatesB)).isEqualTo(2);
        assertThat(coordinatesB.distance(coordinatesA)).isEqualTo(2);
    }

    @Test
    void diagonalDistance() {
        Coordinates coordinatesA = Coordinates.of(5, 5);
        Coordinates coordinatesB = Coordinates.of(4, 4);
        assertThat(coordinatesA.distance(coordinatesB)).isEqualTo(1.4142135623730951);
        assertThat(coordinatesB.distance(coordinatesA)).isEqualTo(1.4142135623730951);
    }

    @Test
    void diagonalDistance2() {
        Coordinates coordinatesA = Coordinates.of(5, 5);
        Coordinates coordinatesB = Coordinates.of(4, 3);
        assertThat(coordinatesA.distance(coordinatesB)).isEqualTo(2.23606797749979);
        assertThat(coordinatesB.distance(coordinatesA)).isEqualTo(2.23606797749979);
    }


}