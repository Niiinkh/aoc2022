package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnotTest {

    private Knot knot;

    @BeforeEach
    void setup() {
        knot = new Knot();
    }

    @Test
    void newTailHasNoVisitedCoordinates() {
        assertThat(knot.visitedCoordinates()).hasSize(0);
    }

    @Test
    void newCoordinatesGetAddedToSetOfVisitedCoordinates() {
        knot.setCoordinates(Coordinates.of(1, 3));
        knot.setCoordinates(Coordinates.of(-1, 3));
        knot.setCoordinates(Coordinates.of(5, 5));
        assertThat(knot.visitedCoordinates()).hasSize(3);
    }

    @Test
    void duplicateCoordinatesOnlyGetAddedOnce() {
        knot.setCoordinates(Coordinates.of(5, 5));
        knot.setCoordinates(Coordinates.of(5, 5));
        assertThat(knot.visitedCoordinates()).hasSize(1);
    }

}