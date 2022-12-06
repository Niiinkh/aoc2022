package de.aboueldahab.aoc.day06;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day06.txt");
        System.out.println("--------------");
        System.out.println("Day 6 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - start of packet marker: " + getPart1Solution(input.get(0)));
    }

    protected static int getPart1Solution(String input) {
        return new SignalProcessor().startOfPacketMarker(input);
    }
}
