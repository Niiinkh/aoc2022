package de.aboueldahab.aoc.day01.application;

import de.aboueldahab.aoc.day01.adapter.FilePuzzleInput;
import de.aboueldahab.aoc.day01.domain.PuzzleDomain;

public class Application {

    public static void main(String[] args) {
        PuzzleDomain puzzleDomain = new PuzzleDomain(new FilePuzzleInput());
        System.out.println("--------------");
        System.out.println("Day 1 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - Elf with most calories: " + puzzleDomain.getMostCalories());
        System.out.println("Part 2 - Top 3 Elves with most calories: " + puzzleDomain.getMostCaloriesFromTop3Elves());
    }

}
