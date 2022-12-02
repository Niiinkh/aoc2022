package de.aboueldahab.aoc.day02.application;

import de.aboueldahab.aoc.day02.adapter.RockPaperScissorParser;
import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.PuzzleInput;
import de.aboueldahab.aoc.day02.domain.Tournament;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExampleInputTest {


    @Test
    void exampleInput_part1() {
        Tournament tournament = new Tournament(new ExamplePuzzleInput().getInputForPart1());
        Assertions.assertThat(tournament.getTotalScore()).isEqualTo(15);
    }

    @Test
    void exampleInput_part2() {
        Tournament tournament = new Tournament(new ExamplePuzzleInput().getInputForPart2());
        Assertions.assertThat(tournament.getTotalScore()).isEqualTo(12);
    }

    class ExamplePuzzleInput implements PuzzleInput {

        private final List<String> input = Arrays.asList(
                "A Y",
                "B X",
                "C Z");

        @Override
        public List<GameRound> getInputForPart1() {
            return new RockPaperScissorParser().convertPart1(input);
        }

        @Override
        public List<GameRound> getInputForPart2() {
            return new RockPaperScissorParser().convertPart2(input);
        }
    }
}
