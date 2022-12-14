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

    @Test
    void part2_exampleInput() {
        assertThat(PuzzleSolver.getPart2Solution(input)).isEqualTo(1);
    }

    @Test
    void part2_largerExample() {
        List<String> largerInput = Arrays.asList(
                "R 5",
                "U 8",
                "L 8",
                "D 3",
                "R 17",
                "D 10",
                "L 25",
                "U 20");
        assertThat(PuzzleSolver.getPart2Solution(largerInput)).isEqualTo(36);
    }

}