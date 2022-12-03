package de.aboueldahab.aoc.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ElfGroup {

    private List<String> elves;

    public ElfGroup(List<String> elves) {
        if (elves.size() != 3) {
            throw new IllegalArgumentException("There must be exactly three elves in a group");
        }
        this.elves = elves;
    }

    public char getBadge() {
        List<String> allLettersInOrder = elves.stream()
                .flatMap(string -> convertToListOfLetters(string).stream())
                .sorted()
                .collect(Collectors.toList());
        String lastLetter = null;
        int count = 0;
        for (String s : allLettersInOrder) {
            if (lastLetter == null) {
                lastLetter = s;
                count = 1;
                continue;
            }
            if (s.equals(lastLetter)) {
                count++;
                if (count == 3) {
                    return s.toCharArray()[0];
                }
            } else {
                lastLetter = s;
                count = 1;
            }
        }
        throw new IllegalStateException("there is no batch for this group of elves");
    }

    private List<String> convertToListOfLetters(String string) {
        List<String> letters = new ArrayList<>();
        for (char aChar : string.toCharArray()) {
            if (!letters.contains(Character.toString(aChar))) {
                letters.add(Character.toString(aChar));
            }
        }
        return letters;
    }

    public int getPriority() {
        return new PriorityCalculator().getPriority(getBadge());
    }
}
