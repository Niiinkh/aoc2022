package de.aboueldahab.aoc.day03.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class RucksackTest {


    @Test
    void contentMustNotBeNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Rucksack(null));
    }

    @Test
    void contentLengthMustBeDivisibleByTwo() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Rucksack("123"));
    }

    @Test
    void contentIsSplitIntoTwoEqualCompartments() {
        Rucksack rucksack = new Rucksack("1234");
        assertThat(rucksack.getFirstCompartment()).isEqualTo("12");
        assertThat(rucksack.getSecondCompartment()).isEqualTo("34");
    }

}