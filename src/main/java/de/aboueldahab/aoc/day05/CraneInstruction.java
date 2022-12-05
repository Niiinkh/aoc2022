package de.aboueldahab.aoc.day05;

public class CraneInstruction {

    private final int itemCount;
    private final Integer crateFrom;
    private final Integer crateTo;

    public CraneInstruction(String input) {
        String[] split = input.split(" ");
        this.itemCount = Integer.parseInt(split[1]);
        this.crateFrom = Integer.parseInt(split[3]);
        this.crateTo = Integer.parseInt(split[5]);
    }

    public int itemCount() {
        return itemCount;
    }

    public Integer crateFrom() {
        return crateFrom;
    }

    public Integer crateTo() {
        return crateTo;
    }
}
