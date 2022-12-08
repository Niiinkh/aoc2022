package de.aboueldahab.aoc.day07;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleSolverTest {

    private List<String> exampleInput = Arrays.asList(
            "$ cd /",
            "$ ls",
            "dir a",
            "14848514 b.txt",
            "8504156 c.dat",
            "dir d",
            "$ cd a",
            "$ ls",
            "dir e",
            "29116 f",
            "2557 g",
            "62596 h.lst",
            "$ cd e",
            "$ ls",
            "584 i",
            "$ cd ..",
            "$ cd ..",
            "$ cd d",
            "$ ls",
            "4060174 j",
            "8033020 d.log",
            "5626152 d.ext",
            "7214296 k");

    @Test
    void part1_exampleInput() {
        assertThat(new PuzzleSolver().getPart1Solution(exampleInput)).isEqualTo(95437);
    }

    @Test
    void part2_exampleInput() {
        assertThat(new PuzzleSolver().getPart2Solution(exampleInput)).isEqualTo(24933642);
    }

}