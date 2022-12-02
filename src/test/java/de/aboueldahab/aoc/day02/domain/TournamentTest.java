package de.aboueldahab.aoc.day02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TournamentTest {

    private ArrayList<GameRound> rounds;
    private Tournament tournament;

    @BeforeEach
    void setup() {
        rounds = new ArrayList<>();
        tournament = new Tournament(new FakePuzzleInput());
    }

    @Test
    void tournamentWithoutRoundsHasNoPoints() {
        assertThat(tournament.getTotalScore()).isEqualTo(0);
    }

    @Test
    void tournamentWithRoundsIsSumOfPoints() {
        rounds.add(new GameRound(HandShape.ROCK, HandShape.ROCK)); // 4 points
        rounds.add(new GameRound(HandShape.ROCK, HandShape.ROCK)); // 4 points
        assertThat(tournament.getTotalScore()).isEqualTo(8);
    }

    class FakePuzzleInput implements PuzzleInput {

        @Override
        public List<GameRound> getInput() {
            return rounds;
        }
    }

}