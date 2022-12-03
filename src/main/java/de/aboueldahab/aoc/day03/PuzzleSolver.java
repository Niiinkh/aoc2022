package de.aboueldahab.aoc.day03;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day03.txt");
        System.out.println("--------------");
        System.out.println("Day 3 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - sum of priorities: " + getPrioritiesForRucksacks(input));
        System.out.println("Part 2 - sum of priorities: " + getPrioritiesForBadges(input));

    }

    public static Integer getPrioritiesForRucksacks(List<String> input) {
        return input.stream()
                .map(Rucksack::new)
                .map(Rucksack::getPriority)
                .reduce(Integer::sum).orElse(0);
    }

    public static Integer getPrioritiesForBadges(List<String> input) {
        List<ElfGroup> groups = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < input.size(); i += 3) {
            groups.add(new ElfGroup(Arrays.asList(input.get(i), input.get(i + 1), input.get(i + 2))));
        }
        return groups.stream()
                .map(ElfGroup::getPriority)
                .reduce(Integer::sum).orElse(0);
    }

}
