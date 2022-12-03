package de.aboueldahab.aoc.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    @Test
    void exampleInputPart1() {
        Integer priorities = PuzzleSolver.getPriorities(
                Arrays.asList(
                        "vJrwpWtwJgWrhcsFMMfFFhFp",
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                        "PmmdzqPrVvPwwTWBwg",
                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                        "ttgJtRGJQctTZtZT",
                        "CrZsJsPPZsGzwwsLwLmpwMDw"));
        assertThat(priorities).isEqualTo(157);
    }

}