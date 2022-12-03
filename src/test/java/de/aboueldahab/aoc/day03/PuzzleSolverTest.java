package de.aboueldahab.aoc.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    private List<String> exampleInput = Arrays.asList(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw");

    @Test
    void exampleInputPart1() {
        assertThat(PuzzleSolver.getPrioritiesForRucksacks(exampleInput)).isEqualTo(157);
    }

    @Test
    void exampleInputPart2() {
        assertThat(PuzzleSolver.getPrioritiesForBadges(exampleInput)).isEqualTo(70);
    }

}