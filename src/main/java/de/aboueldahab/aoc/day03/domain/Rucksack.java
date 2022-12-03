package de.aboueldahab.aoc.day03.domain;

public class Rucksack {

    private final String firstCompartment;
    private final String secondCompartment;

    public Rucksack(String content) {
        if (content == null || content.length() % 2 != 0) {
            throw new IllegalArgumentException("The content must be splittable into two equal compartments");
        }
        int middle = content.length() / 2;
        firstCompartment = content.substring(0, middle);
        secondCompartment = content.substring(middle);
    }

    public String getFirstCompartment() {
        return firstCompartment;
    }

    public String getSecondCompartment() {
        return secondCompartment;
    }
}
