package de.aboueldahab.aoc.day04;

public class SectionRange {

    private final int lowerBound;
    private final int upperBound;

    public SectionRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean fullyContains(SectionRange other) {
        return this.lowerBound <= other.lowerBound && this.upperBound >= other.upperBound;
    }

    public int lowerBound() {
        return lowerBound;
    }

    public int upperBound() {
        return upperBound;
    }
}
