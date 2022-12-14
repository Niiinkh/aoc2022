package de.aboueldahab.aoc.day09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    private final List<String> input = Arrays.asList(
            "R 4",
            "U 4",
            "L 3",
            "D 1",
            "R 4",
            "D 1",
            "L 5",
            "R 2");

    @Test
    void part1_exampleInput() {
        assertThat(PuzzleSolver.getPart1Solution(input)).isEqualTo(13);
    }

}