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

    @Test
    void rangeAIsBelowRangeB() {
        SectionRange rangeA = new SectionRange(1, 3);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isFalse();
        assertThat(rangeB.hasOverlap(rangeA)).isFalse();
    }

    @Test
    void rangeATouchesLowerBound() {
        SectionRange rangeA = new SectionRange(1, 4);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isTrue();
        assertThat(rangeB.hasOverlap(rangeA)).isTrue();
    }

    @Test
    void rangeACrossesLowerBound() {
        SectionRange rangeA = new SectionRange(1, 5);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isTrue();
        assertThat(rangeB.hasOverlap(rangeA)).isTrue();
    }


    @Test
    void rangeAIsAboveRangeB() {
        SectionRange rangeA = new SectionRange(8, 12);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isFalse();
        assertThat(rangeB.hasOverlap(rangeA)).isFalse();
    }

    @Test
    void rangeATouchesRangeBUpperBound() {
        SectionRange rangeA = new SectionRange(7, 12);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isTrue();
        assertThat(rangeB.hasOverlap(rangeA)).isTrue();
    }

    @Test
    void rangeACrossesRangeBUpperBound() {
        SectionRange rangeA = new SectionRange(6, 12);
        SectionRange rangeB = new SectionRange(4, 7);
        assertThat(rangeA.hasOverlap(rangeB)).isTrue();
        assertThat(rangeB.hasOverlap(rangeA)).isTrue();
    }
}