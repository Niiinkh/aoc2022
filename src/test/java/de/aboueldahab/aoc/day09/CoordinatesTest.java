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


}