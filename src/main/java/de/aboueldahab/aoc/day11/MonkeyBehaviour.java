package de.aboueldahab.aoc.day11;

public class MonkeyBehaviour {

    private final int divisibleBy;

    public MonkeyBehaviour(int divisibleBy) {
        this.divisibleBy = divisibleBy;
    }

    public boolean test(Item item) {
        return item.worryLevel() % divisibleBy == 0;
    }

    public int divisibleBy() {
        return divisibleBy;
    }
}
