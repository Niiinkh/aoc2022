package de.aboueldahab.aoc.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PriorityCalculatorTest {

    private PriorityCalculator priorityCalculator;

    @BeforeEach
    void setup() {
        priorityCalculator = new PriorityCalculator();
    }

    @Test
    void lowerCaseLettersAreCorrect() {
        assertThat(priorityCalculator.getPriority('a')).isEqualTo(1);
        assertThat(priorityCalculator.getPriority('z')).isEqualTo(26);
    }

    @Test
    void upperCaseLettersAreCorrect() {
        assertThat(priorityCalculator.getPriority('A')).isEqualTo(27);
        assertThat(priorityCalculator.getPriority('Z')).isEqualTo(52);
    }

}