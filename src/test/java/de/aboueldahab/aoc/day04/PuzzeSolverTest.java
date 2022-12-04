package de.aboueldahab.aoc.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzeSolverTest {

    private List<String> exampleInput = Arrays.asList(
            "2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8");

    @Test
    void exampleInputPart1() {
        assertThat(PuzzeSolver.getFullyOverlappingPairs(exampleInput)).isEqualTo(2);
    }

    @Test
    void exampleInputPart2() {
        assertThat(PuzzeSolver.getAnyOverlappingPairs(exampleInput)).isEqualTo(4);
    }

}