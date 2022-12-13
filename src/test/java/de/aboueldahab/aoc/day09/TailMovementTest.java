package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TailMovementTest {

    private TailMovement tailMovement;
    private Tail tail;

    @BeforeEach
    void setup() {
        tail = new Tail();
        tail.setCoordinates(Coordinates.of(0, 0));
        tailMovement = new TailMovement(tail);
    }

    @Test
    void startingCoordinatesOfHeadAreDetermined() {
        assertThat(tailMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 0));
        assertThat(tailMovement.tailCoordinates()).isEqualTo(Coordinates.of(0, 0));
    }

    @Test
    void headMovingUpIncreasesY() {
        tailMovement.moveHeadUp();
        assertThat(tailMovement.headCoordinates()).isEqualTo(Coordinates.of(0, 1));
    }

    @Test
    void headMovingDownDecreasesY() {
        tailMovement.moveHeadDown();
        assertThat(tailMovement.headCoordinates()).isEqualTo(Coordinates.of(0, -1));
    }

    @Test
    void headMovingRightIncreasesX() {
        tailMovement.moveHeadRight();
        assertThat(tailMovement.headCoordinates()).isEqualTo(Coordinates.of(1, 0));
    }

    @Test
    void headMovingLeftDecreasesX() {
        tailMovement.moveHeadLeft();
        assertThat(tailMovement.headCoordinates()).isEqualTo(Coordinates.of(-1, 0));
    }

}