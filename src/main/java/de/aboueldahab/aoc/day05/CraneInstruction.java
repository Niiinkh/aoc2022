package de.aboueldahab.aoc.day05;

public class CraneInstruction {

    private final int itemCount;
    private final Integer stackFrom;
    private final Integer stackTo;

    public CraneInstruction(String input) {
        String[] split = input.split(" ");
        this.itemCount = Integer.parseInt(split[1]);
        this.stackFrom = Integer.parseInt(split[3]);
        this.stackTo = Integer.parseInt(split[5]);
    }

    public int itemCount() {
        return itemCount;
    }

    public Integer stackFrom() {
        return stackFrom;
    }

    public Integer stackTo() {
        return stackTo;
    }
}
