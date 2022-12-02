package de.aboueldahab.aoc.day02.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundTest {


    @Test
    void pointsAreCalculatedForFirstHand() {
        GameRound gameRound = new GameRound(HandShape.SCISSORS, HandShape.PAPER);
        assertThat(gameRound.calculatePoints()).isEqualTo(9);
    }
}