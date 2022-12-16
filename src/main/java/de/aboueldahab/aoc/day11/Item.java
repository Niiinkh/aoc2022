package de.aboueldahab.aoc.day11;

public class Item {

    private int worryLevel;

    public Item(int initialWorryLevel) {
        this.worryLevel = initialWorryLevel;
    }

    public int worryLevel() {
        return worryLevel;
    }

    public void setWorryLevel(int worryLevel) {
        this.worryLevel = worryLevel;
    }

}
