package de.aboueldahab.aoc.day09;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day09.txt");
        System.out.println("--------------");
        System.out.println("Day 9 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - total number of positions the tail visited: " + getPart1Solution(input));
    }

    protected static long getPart1Solution(List<String> input) {
        TailMovement movement = createTail();
        input.forEach(line -> execute(movement, line));
        return movement.tail().visitedCoordinates().size();
    }

    private static void execute(TailMovement movement, String line) {
        String direction = line.split(" ")[0];
        int count = Integer.parseInt(line.split(" ")[1]);
        for (int i = 0; i < count; i++) {
            switch (direction) {
                case "R" -> movement.moveHeadRight();
                case "L" -> movement.moveHeadLeft();
                case "D" -> movement.moveHeadDown();
                case "U" -> movement.moveHeadUp();
            }
        }
    }

    private static TailMovement createTail() {
        Tail tail = new Tail();
        tail.setCoordinates(Coordinates.of(0, 0));
        return new TailMovement(tail);
    }


}
