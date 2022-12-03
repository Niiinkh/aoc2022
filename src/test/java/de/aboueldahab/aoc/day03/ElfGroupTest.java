package de.aboueldahab.aoc.day03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ElfGroupTest {

    @Test
    void wrongNumberOfElvesThrowsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new ElfGroup(Arrays.asList("1", "2")));
    }

    @Test
    void allDifferentStrings_noBatch() {
        ElfGroup elfGroup = new ElfGroup(Arrays.asList("ab", "cd", "ef"));
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> elfGroup.getBadge());
    }

    @Test
    void onlyTwoElvesMatch_noBatch() {
        ElfGroup elfGroup = new ElfGroup(Arrays.asList("ab", "ca", "ef"));
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> elfGroup.getBadge());
    }

    @Test
    void allThreeElvesMatch_batchCanBeDetermined() {
        ElfGroup elfGroup = new ElfGroup(Arrays.asList("abxc", "dxfe", "ghix"));
        assertThat(elfGroup.getBadge()).isEqualTo('x');
    }

}