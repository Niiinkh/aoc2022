package de.aboueldahab.aoc.day05;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;
import java.util.stream.Collectors;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day05.txt");
        Day5InputParser inputParser = new Day5InputParser(input);
        System.out.println("--------------");
        System.out.println("Day 5 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - crates on top after rearrangements (reverse order): " + getPart1Solution(inputParser));
        System.out.println("Part 2 - crates on top after rearrangements (keeping order): " + getPart2Solution(inputParser));
    }

    protected static String getPart1Solution(Day5InputParser input) {
        CargoShip ship = input.createInitialCargoShip();
        input.getCraneInstructions().forEach(
                instruction -> ship.rearrangeReverseOrder(new CraneInstruction(instruction))
        );
        return ship.getTopCrates().stream().collect(Collectors.joining());
    }

    protected static String getPart2Solution(Day5InputParser input) {
        CargoShip ship = input.createInitialCargoShip();
        input.getCraneInstructions().forEach(
                instruction -> ship.rearrangeKeepOrder(new CraneInstruction(instruction))
        );
        return ship.getTopCrates().stream().collect(Collectors.joining());
    }
}
