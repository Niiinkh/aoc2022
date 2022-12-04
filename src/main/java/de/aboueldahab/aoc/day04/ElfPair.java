package de.aboueldahab.aoc.day04;

public class ElfPair {

    private final SectionRange firstElf;
    private final SectionRange secondElf;

    public ElfPair(String input) {
        String[] elves = input.split(",");
        firstElf = getSectionRange(elves[0]);
        secondElf = getSectionRange(elves[1]);
    }

    public boolean hasFullOverlap() {
        return firstElf.fullyContains(secondElf) || secondElf.fullyContains(firstElf);
    }

    public SectionRange firstElf() {
        return firstElf;
    }

    public SectionRange secondElf() {
        return secondElf;
    }

    private static SectionRange getSectionRange(String elf) {
        String[] idRange = elf.split("-");
        return new SectionRange(Integer.parseInt(idRange[0]), Integer.parseInt(idRange[1]));
    }
}
