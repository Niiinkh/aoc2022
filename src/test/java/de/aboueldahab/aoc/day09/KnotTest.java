package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnotTest {

    private Knot knot;

    @BeforeEach
    void setup() {
        knot = new Knot();
        knot.setCoordinates(Coordinates.of(0, 0));
    }

    @Test
    void newTailHasNoVisitedCoordinates() {
        assertThat(new Knot().visitedCoordinates()).hasSize(0);
    }

    @Test
    void newCoordinatesGetAddedToSetOfVisitedCoordinates() {
        Knot knot = new Knot();
        knot.setCoordinates(Coordinates.of(1, 3));
        knot.setCoordinates(Coordinates.of(-1, 3));
        knot.setCoordinates(Coordinates.of(5, 5));
        assertThat(knot.visitedCoordinates()).hasSize(3);
    }

    @Test
    void duplicateCoordinatesOnlyGetAddedOnce() {
        Knot knot = new Knot();
        knot.setCoordinates(Coordinates.of(5, 5));
        knot.setCoordinates(Coordinates.of(5, 5));
        assertThat(knot.visitedCoordinates()).hasSize(1);
    }

    @Test
    void followingKnotInheritsCoordinates() {
        Knot tail = new Knot();
        knot.setCoordinates(Coordinates.of(7, 3));
        knot.setFollowingKnot(tail);
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(7, 3));
    }

    @Test
    void followingKnotHasInheritedCoordinatesInItsListOfVisitedCoordinates() {
        Knot tail = new Knot();
        knot.setCoordinates(Coordinates.of(7, 3));
        knot.setFollowingKnot(tail);
        assertThat(tail.visitedCoordinates()).containsExactly(Coordinates.of(7, 3));
    }

    @Test
    void headMovingUpIncreasesY() {
        knot.moveUp();
        assertThat(knot.currentCoordinates()).isEqualTo(Coordinates.of(0, 1));
    }

    @Test
    void headMovingDownDecreasesY() {
        knot.moveDown();
        assertThat(knot.currentCoordinates()).isEqualTo(Coordinates.of(0, -1));
    }

    @Test
    void headMovingRightIncreasesX() {
        knot.moveRight();
        assertThat(knot.currentCoordinates()).isEqualTo(Coordinates.of(1, 0));
    }

    @Test
    void headMovingLeftDecreasesX() {
        knot.moveLeft();
        assertThat(knot.currentCoordinates()).isEqualTo(Coordinates.of(-1, 0));
    }

}