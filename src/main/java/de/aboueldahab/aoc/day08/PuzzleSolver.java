package de.aboueldahab.aoc.day08;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day08.txt");
        System.out.println("--------------");
        System.out.println("Day 8 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - total number of visible trees: " + getPart1Solution(input));
        System.out.println("Part 2 - tree with highest scenic score: " + getPart2Solution(input));
    }

    protected static long getPart1Solution(List<String> input) {
        return createTrees(input).stream().filter(Tree::isVisible).count();
    }

    protected static long getPart2Solution(List<String> input) {
        return createTrees(input).stream()
                .map(Tree::scenicScore)
                .max(Integer::compareTo).orElse(0);
    }

    private static List<Tree> createTrees(List<String> input) {
        return new TreeFactory().createTrees(input);
    }

}
