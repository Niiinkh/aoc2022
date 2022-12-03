package de.aboueldahab.aoc.day03;

public class PriorityCalculator {

    public int getPriority(char character) {
        if (isLowerCase(character))
            return character - 96;
        if (isUpperCase(character))
            return character - 38;
        throw new IllegalArgumentException(String.format("Character %s is not a letter", character));
    }


    private boolean isLowerCase(char character) {
        return character >= 96 && character <= 122;
    }

    private boolean isUpperCase(int character) {
        return character >= 65 && character <= 90;
    }

}
