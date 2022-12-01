package de.aboueldahab.aoc.day01.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleDomain {

    private PuzzleInputPort puzzleInput;

    public PuzzleDomain(PuzzleInputPort puzzleInput) {
        this.puzzleInput = puzzleInput;
    }

    public int getMostCalories() {
        return getElvesSortedByMostCalories().stream().findFirst().map(Elf::getCalories).orElse(0);
    }


    public int getMostCaloriesFromTop3Elves() {
        return getElvesSortedByMostCalories().stream().limit(3).map(Elf::getCalories).reduce(Integer::sum).orElse(0);
    }

    protected List<Elf> getElvesSortedByMostCalories() {
        return puzzleInput.getElves().stream().sorted(Comparator.comparing(Elf::getCalories).reversed()).collect(Collectors.toList());
    }
}
