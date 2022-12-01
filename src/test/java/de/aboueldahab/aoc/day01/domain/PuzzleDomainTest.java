package de.aboueldahab.aoc.day01.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PuzzleDomainTest {

    private PuzzleDomain domain;
    private PuzzleInputPort puzzleInput;
    private List<Elf> elves;

    @BeforeEach
    void setup() {
        puzzleInput = new FakePuzzleInport();
        domain = new PuzzleDomain(puzzleInput);
    }

    @Test
    void elfWithMostCalories_emptyList() {
        elves = Collections.emptyList();
        assertThat(domain.getElfWithMostCalories()).isEmpty();
    }

    @Test
    void elfWithMostCalories_oneElf() {
        Elf elf = new Elf();
        elves = Arrays.asList(elf);
        assertThat(domain.getElfWithMostCalories()).get().isEqualTo(elf);
    }

    @Test
    void elfWithMostCalories_multipleElves() {
        Elf elf1 = new Elf();
        Elf elf2 = new Elf();
        Elf elf3 = new Elf();
        elves = Arrays.asList(elf1, elf2, elf3);

        elf1.addFood(27);
        elf2.addFood(28);
        elf1.addFood(0);

        assertThat(domain.getElfWithMostCalories()).get().isEqualTo(elf2);
    }

    class FakePuzzleInport implements PuzzleInputPort {

        @Override
        public List<Elf> getElves() {
            return elves;
        }
    }

}