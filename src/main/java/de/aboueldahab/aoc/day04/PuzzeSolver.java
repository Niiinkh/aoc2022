package de.aboueldahab.aoc.day04;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzeSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day04.txt");
        System.out.println("--------------");
        System.out.println("Day 4 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - number of fully overlapping pairs: " + getFullyOverlappingPairs(input));
        System.out.println("Part 2 - number of all overlapping pairs: " + getAnyOverlappingPairs(input));
    }

    public static long getFullyOverlappingPairs(List<String> input) {
        return input.stream()
                .map(ElfPair::new)
                .filter(ElfPair::hasFullOverlap)
                .count();
    }

    public static long getAnyOverlappingPairs(List<String> input) {
        return input.stream()
                .map(ElfPair::new)
                .filter(ElfPair::hasAnyOverlap)
                .count();
    }
}
