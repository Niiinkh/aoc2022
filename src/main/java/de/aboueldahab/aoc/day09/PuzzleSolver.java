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
        System.out.println("Part 2 - total number of positions tail no. 9 visited: " + getPart2Solution(input));
    }

    protected static long getPart1Solution(List<String> input) {
        Knot head = new Knot();
        head.setCoordinates(Coordinates.of(0, 0));
        Knot tail = addTail(head);

        input.forEach(line -> execute(head, line));

        return tail.visitedCoordinates().size();
    }

    protected static long getPart2Solution(List<String> input) {
        Knot head = new Knot();
        head.setCoordinates(Coordinates.of(0, 0));
        Knot tail1 = addTail(head);
        Knot tail2 = addTail(tail1);
        Knot tail3 = addTail(tail2);
        Knot tail4 = addTail(tail3);
        Knot tail5 = addTail(tail4);
        Knot tail6 = addTail(tail5);
        Knot tail7 = addTail(tail6);
        Knot tail8 = addTail(tail7);
        Knot tail9 = addTail(tail8);

        input.forEach(line -> execute(head, line));

        return tail9.visitedCoordinates().size();
    }

    private static Knot addTail(Knot head) {
        Knot tail = new Knot();
        head.setFollowingKnot(tail);
        return tail;
    }

    private static void execute(Knot head, String line) {
        String direction = line.split(" ")[0];
        int count = Integer.parseInt(line.split(" ")[1]);
        for (int i = 0; i < count; i++) {
            switch (direction) {
                case "R" -> head.moveRight();
                case "L" -> head.moveLeft();
                case "D" -> head.moveDown();
                case "U" -> head.moveUp();
            }
        }
    }


}
