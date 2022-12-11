package de.aboueldahab.aoc.day08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    private final List<String> input = Arrays.asList(
            "30373",
            "25512",
            "65332",
            "33549",
            "35390");

    @Test
    void part1_exampleInput() {
        assertThat(PuzzleSolver.getPart1Solution(input)).isEqualTo(21);
    }

}