package de.aboueldahab.aoc.day10;

public class OperationParser {

    public Operation parseInput(String input) {
        if (input.equals("noop")) {
            return new NoOp();
        }
        if (input.startsWith("addx")) {
            int value = Integer.parseInt(input.split(" ")[1]);
            return new AddValueOp(value);
        }
        throw new IllegalArgumentException("unknown op: " + input);
    }

}
