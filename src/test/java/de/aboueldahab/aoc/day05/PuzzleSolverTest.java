package de.aboueldahab.aoc.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    private Day5InputParser input;

    @BeforeEach
    void setup() {
        input = new Day5InputParser(Day5InputParserTest.exampleInput);
    }

    @Test
    void exampleInput_part1() {
        assertThat(PuzzleSolver.getPart1Solution(input)).isEqualTo("CMZ");
    }

}