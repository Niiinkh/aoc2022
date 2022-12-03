package de.aboueldahab.aoc.day03;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day03.txt");
        System.out.println("--------------");
        System.out.println("Day 3 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - sum of priorities: " + getPriorities(input));

    }

    public static Integer getPriorities(List<String> input) {
        return input.stream()
                .map(Rucksack::new)
                .map(Rucksack::getPriority)
                .reduce(Integer::sum).orElse(0);
    }

}
