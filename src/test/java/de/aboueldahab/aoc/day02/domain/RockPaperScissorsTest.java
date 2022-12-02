package de.aboueldahab.aoc.day02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RockPaperScissorsTest {

    private RockPaperScissors game;

    @BeforeEach
    void setup() {
        game = new RockPaperScissors();
    }

    @Test
    void rockAndLossIsOnePoint() {
        assertThat(game.getPoints(HandShape.ROCK, Result.LOSS)).isEqualTo(1);
    }

    @Test
    void paperAndLossIsTwoPoints() {
        assertThat(game.getPoints(HandShape.PAPER, Result.LOSS)).isEqualTo(2);
    }

    @Test
    void scissorsAndLossIsThreePoints() {
        assertThat(game.getPoints(HandShape.SCISSORS, Result.LOSS)).isEqualTo(3);
    }

    @Test
    void rockAndDrawIsFourPoints() {
        assertThat(game.getPoints(HandShape.ROCK, Result.DRAW)).isEqualTo(4);
    }

    @Test
    void paperAndDrawIsFivePoints() {
        assertThat(game.getPoints(HandShape.PAPER, Result.DRAW)).isEqualTo(5);
    }

    @Test
    void scissorsAndDrawIsSixPoints() {
        assertThat(game.getPoints(HandShape.SCISSORS, Result.DRAW)).isEqualTo(6);
    }

    @Test
    void rockAndWinIsSevenPoints() {
        assertThat(game.getPoints(HandShape.ROCK, Result.WIN)).isEqualTo(7);
    }

    @Test
    void paperAndWinIsEightPoints() {
        assertThat(game.getPoints(HandShape.PAPER, Result.WIN)).isEqualTo(8);
    }

    @Test
    void scissorsAndWinIsNinePoints() {
        assertThat(game.getPoints(HandShape.SCISSORS, Result.WIN)).isEqualTo(9);
    }

    @Test
    void playerANeedShapesAssigned() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> game.determineResult(null, HandShape.PAPER));
    }

    @Test
    void playerBNeedShapesAssigned() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> game.determineResult(HandShape.PAPER, null));
    }

    @Test
    void sameHandLeedsToDraw() {
        assertThat(game.determineResult(HandShape.SCISSORS, HandShape.SCISSORS)).isEqualTo(Result.DRAW);
    }

    @Test
    void rockBeatsScissors() {
        assertThat(game.determineResult(HandShape.ROCK, HandShape.SCISSORS)).isEqualTo(Result.WIN);
        assertThat(game.determineResult(HandShape.SCISSORS, HandShape.ROCK)).isEqualTo(Result.LOSS);
    }

    @Test
    void scissorsBeatPaper() {
        assertThat(game.determineResult(HandShape.SCISSORS, HandShape.PAPER)).isEqualTo(Result.WIN);
        assertThat(game.determineResult(HandShape.PAPER, HandShape.SCISSORS)).isEqualTo(Result.LOSS);
    }

    @Test
    void paperBeatsRock() {
        assertThat(game.determineResult(HandShape.PAPER, HandShape.ROCK)).isEqualTo(Result.WIN);
        assertThat(game.determineResult(HandShape.ROCK, HandShape.PAPER)).isEqualTo(Result.LOSS);
    }

}