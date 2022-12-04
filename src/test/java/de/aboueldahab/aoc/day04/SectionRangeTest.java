package de.aboueldahab.aoc.day04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SectionRangeTest {

    @Test
    void identicalSectionsContainEachOther() {
        SectionRange rangeA = new SectionRange(5, 10);
        SectionRange rangeB = new SectionRange(5, 10);
        assertThat(rangeA.fullyContains(rangeB)).isTrue();
        assertThat(rangeB.fullyContains(rangeA)).isTrue();
    }

    @Test
    void overlappingSectionsDontFullyContainEachOther() {
        SectionRange rangeA = new SectionRange(5, 8);
        SectionRange rangeB = new SectionRange(6, 9);
        assertThat(rangeA.fullyContains(rangeB)).isFalse();
        assertThat(rangeB.fullyContains(rangeA)).isFalse();
    }

    @Test
    void callerAndCalleeOfSectionRangeIsImportant() {
        SectionRange rangeA = new SectionRange(5, 10);
        SectionRange rangeB = new SectionRange(6, 9);
        assertThat(rangeA.fullyContains(rangeB)).isTrue();
        assertThat(rangeB.fullyContains(rangeA)).isFalse();
    }
}