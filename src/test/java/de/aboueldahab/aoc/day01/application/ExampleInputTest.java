package de.aboueldahab.aoc.day01.application;

import de.aboueldahab.aoc.day01.adapter.ElfInputConverter;
import de.aboueldahab.aoc.day01.domain.Elf;
import de.aboueldahab.aoc.day01.domain.PuzzleDomain;
import de.aboueldahab.aoc.day01.domain.PuzzleInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleInputTest {

    private PuzzleDomain puzzleDomain;

    @BeforeEach
    void setup() {
        puzzleDomain = new PuzzleDomain(new ExamplePuzzleInput());
    }

    @Test
    void exampleInput_part1() {
        assertThat(puzzleDomain.getMostCalories()).isEqualTo(24000);
    }

    @Test
    void exampleInput_part2() {
        assertThat(puzzleDomain.getMostCaloriesFromTop3Elves()).isEqualTo(45000);
    }


    class ExamplePuzzleInput implements PuzzleInputPort {

        @Override
        public List<Elf> getElves() {
            return new ElfInputConverter().convert(Arrays.asList(
                    "1000",
                    "2000",
                    "3000",
                    "",
                    "4000",
                    "",
                    "5000",
                    "6000",
                    "",
                    "7000",
                    "8000",
                    "9000",
                    "",
                    "10000"
            ));
        }
    }

}
