package de.aboueldahab.aoc.day01.application;

import de.aboueldahab.aoc.day01.adapter.FilePuzzleInput;
import de.aboueldahab.aoc.day01.domain.PuzzleDomain;

public class Application {

    public static void main(String[] args) {
        PuzzleDomain puzzleDomain = new PuzzleDomain(new FilePuzzleInput());
        System.out.println("Day 1 Solution");
        System.out.println("Elf with most calories: " + puzzleDomain.getMostCalories());
    }

}
