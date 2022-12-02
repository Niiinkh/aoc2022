package de.aboueldahab.aoc.day02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest {

    private Player player1;
    private Player player2;

    @BeforeEach
    void setup() {
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    void playerANeedShapesAssigned() {
        player1.setShape(null);
        player2.setShape(HandShape.PAPER);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> player1.playAgainst(player2));
    }

    @Test
    void playerBNeedShapesAssigned() {
        player1.setShape(HandShape.PAPER);
        player2.setShape(null);
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> player1.playAgainst(player2));
    }

    @Test
    void sameHandLeedsToDraw() {
        player1.setShape(HandShape.SCISSORS);
        player2.setShape(HandShape.SCISSORS);
        assertThat(player1.playAgainst(player2)).isEqualTo(Result.DRAW);
        assertThat(player2.playAgainst(player1)).isEqualTo(Result.DRAW);
    }

    @Test
    void rockBeatsScissors() {
        player1.setShape(HandShape.ROCK);
        player2.setShape(HandShape.SCISSORS);
        assertThat(player1.playAgainst(player2)).isEqualTo(Result.WIN);
        assertThat(player2.playAgainst(player1)).isEqualTo(Result.LOSS);
    }

    @Test
    void scissorsBeatPaper() {
        player1.setShape(HandShape.SCISSORS);
        player2.setShape(HandShape.PAPER);
        assertThat(player1.playAgainst(player2)).isEqualTo(Result.WIN);
        assertThat(player2.playAgainst(player1)).isEqualTo(Result.LOSS);
    }

    @Test
    void paperBeatsRock() {
        player1.setShape(HandShape.PAPER);
        player2.setShape(HandShape.ROCK);
        assertThat(player1.playAgainst(player2)).isEqualTo(Result.WIN);
        assertThat(player2.playAgainst(player1)).isEqualTo(Result.LOSS);
    }

}