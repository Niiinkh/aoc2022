package de.aboueldahab.aoc.day02.application;

import de.aboueldahab.aoc.day02.adapter.RockPaperScissorParser;
import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.PuzzleInput;
import de.aboueldahab.aoc.day02.domain.Tournament;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExampleInputTest {

    private Tournament tournament;

    @BeforeEach
    void setup() {
        tournament = new Tournament(new ExamplePuzzleInput());
    }

    @Test
    void exampleInput_part1() {
        Assertions.assertThat(tournament.getTotalScore()).isEqualTo(15);
    }

    class ExamplePuzzleInput implements PuzzleInput {

        @Override
        public List<GameRound> getInput() {
            return new RockPaperScissorParser().convert(Arrays.asList(
                    "A Y",
                    "B X",
                    "C Z"
            ));
        }
    }
}
