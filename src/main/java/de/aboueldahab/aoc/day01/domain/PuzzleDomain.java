package de.aboueldahab.aoc.day01.domain;

import java.util.Comparator;
import java.util.Optional;

public class PuzzleDomain {

    private PuzzleInputPort puzzleInput;

    public PuzzleDomain(PuzzleInputPort puzzleInput) {
        this.puzzleInput = puzzleInput;
    }

    public Optional<Elf> getElfWithMostCalories() {
        return puzzleInput.getElves().stream().max(Comparator.comparing(Elf::getCalories));
    }

    public int getMostCalories() {
        return getElfWithMostCalories().map(Elf::getCalories).orElse(0);
    }


}
