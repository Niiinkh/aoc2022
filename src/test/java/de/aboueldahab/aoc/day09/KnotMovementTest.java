package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnotMovementTest {

    private KnotMovement knotMovement;
    private Knot knot;

    @BeforeEach
    void setup() {
        knot = new Knot();
        knot.setCoordinates(Coordinates.of(0, 0));
        knotMovement = new KnotMovement(knot);
    }

    @Test
    void startingCoordinatesOfHeadAreDetermined() {
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 0));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingUpIncreasesY() {
        knotMovement.moveHeadUp();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 1));
    }

    @Test
    void headMovingDownDecreasesY() {
        knotMovement.moveHeadDown();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(0, -1));
    }

    @Test
    void headMovingRightIncreasesX() {
        knotMovement.moveHeadRight();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(1, 0));
    }

    @Test
    void headMovingLeftDecreasesX() {
        knotMovement.moveHeadLeft();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(-1, 0));
    }

    @Test
    void headMovingUpOnceTailStaysInPlace() {
        knotMovement.moveHeadUp();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 1));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingDiagonallyTailStaysInPlace() {
        knotMovement.moveHeadUp();
        knotMovement.moveHeadLeft();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(-1, 1));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingUpTwiceForcesTailToFollow() {
        knotMovement.moveHeadUp();
        knotMovement.moveHeadUp();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 2));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 1));
    }

    @Test
    void headMovingLeftTwiceForcesTailToFollow() {
        knotMovement.moveHeadLeft();
        knotMovement.moveHeadLeft();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(-2, 0));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(-1, 0));
    }

    @Test
    void tailMovesDiagonallyInOneStepIfBothXAndYDiffer() {
        knotMovement.moveHeadRight();
        knotMovement.moveHeadUp();
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 0));

        knotMovement.moveHeadUp();
        assertThat(knotMovement.headCoordinates()).isEqualTo(Coordinates.of(1, 2));
        assertThat(knotMovement.tailCoordinates()).isEqualTo(Coordinates.of(1, 1));
        assertThat(knotMovement.tail().visitedCoordinates())
                .containsExactlyInAnyOrder(Coordinates.of(0, 0), Coordinates.of(1, 1));
    }

}