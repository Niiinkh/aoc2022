package de.aboueldahab.aoc.day04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ElfPairTest {

    @Test
    void inputGetsParsedInConstructor() {
        ElfPair elfPair = new ElfPair("1-5,2-4");
        Assertions.assertThat(elfPair.firstElf().lowerBound()).isEqualTo(1);
        Assertions.assertThat(elfPair.firstElf().upperBound()).isEqualTo(5);
        Assertions.assertThat(elfPair.secondElf().lowerBound()).isEqualTo(2);
        Assertions.assertThat(elfPair.secondElf().upperBound()).isEqualTo(4);
    }

}