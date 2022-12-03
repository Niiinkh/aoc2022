package de.aboueldahab.aoc.day03;

import org.apache.commons.lang3.StringUtils;

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

    public char getWrongItem() {
        for (char character : firstCompartment.toCharArray()) {
            if (StringUtils.containsAny(secondCompartment, character)) {
                return character;
            }
        }
        throw new IllegalStateException("There must be exactly one wrong element in each rucksack");
    }

    public int getPriority() {
        return new PriorityCalculator().getPriority(getWrongItem());
    }

}
