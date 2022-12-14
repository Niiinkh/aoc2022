package de.aboueldahab.aoc.day10;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    private static final OperationParser opParser = new OperationParser();

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day10.txt");
        System.out.println("--------------");
        System.out.println("Day 10 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - signal strength during six intervals: " + getPart1Solution(input));
    }

    protected static long getPart1Solution(List<String> input) {
        Register register = new Register();
        input.forEach(line -> register.execute(opParser.parseInput(line)));
        return register.signalStrength();
    }

}
