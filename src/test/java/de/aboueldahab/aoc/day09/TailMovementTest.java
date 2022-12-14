package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TailMovementTest {

    private TailMovement tailMovement;
    private Knot head;
    private Knot tail;

    @BeforeEach
    void setup() {
        head = new Knot();
        tail = new Knot();
        head.setCoordinates(Coordinates.of(0, 0));
        tail.setCoordinates(Coordinates.of(0, 0));
        tailMovement = new TailMovement(head, tail);
    }

    @Test
    void startingCoordinatesOfHeadAreDetermined() {
        assertThat(head.currentCoordinates()).isEqualTo(Coordinates.of(0, 0));
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingUpOnceTailStaysInPlace() {
        head.setCoordinates(Coordinates.of(0, 1));
        tailMovement.tailFollowsHead();
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingDiagonallyTailStaysInPlace() {
        head.setCoordinates(Coordinates.of(-1, 1));
        tailMovement.tailFollowsHead();
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingUpTwiceForcesTailToFollow() {
        head.setCoordinates(Coordinates.of(0, 2));
        tailMovement.tailFollowsHead();
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(0, 1));
    }

    @Test
    void headMovingLeftTwiceForcesTailToFollow() {
        head.setCoordinates(Coordinates.of(-2, 0));
        tailMovement.tailFollowsHead();
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(-1, 0));
    }

    @Test
    void tailMovesDiagonallyInOneStepIfBothXAndYDiffer() {
        head.setCoordinates(Coordinates.of(1, 2));
        tailMovement.tailFollowsHead();
        assertThat(tail.currentCoordinates()).isEqualTo(Coordinates.of(1, 1));
        assertThat(tail.visitedCoordinates()).containsExactlyInAnyOrder(Coordinates.of(0, 0), Coordinates.of(1, 1));
    }

}