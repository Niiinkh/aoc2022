package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TailTest {

    private Tail tail;

    @BeforeEach
    void setup() {
        tail = new Tail();
    }

    @Test
    void newTailHasNoVisitedCoordinates() {
        assertThat(tail.visitedCoordinates()).hasSize(0);
    }

    @Test
    void newCoordinatesGetAddedToSetOfVisitedCoordinates() {
        tail.setCoordinates(Coordinates.of(1, 3));
        tail.setCoordinates(Coordinates.of(-1, 3));
        tail.setCoordinates(Coordinates.of(5, 5));
        assertThat(tail.visitedCoordinates()).hasSize(3);
    }

    @Test
    void duplicateCoordinatesOnlyGetAddedOnce() {
        tail.setCoordinates(Coordinates.of(5, 5));
        tail.setCoordinates(Coordinates.of(5, 5));
        assertThat(tail.visitedCoordinates()).hasSize(1);
    }

}