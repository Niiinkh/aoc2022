package de.aboueldahab.aoc.day05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CraneInstructionTest {

    @Test
    void inputGetsParsedCorrectly() {
        CraneInstruction craneInstruction = new CraneInstruction("move 7 from 9 to 4");
        assertThat(craneInstruction.itemCount()).isEqualTo(7);
        assertThat(craneInstruction.stackFrom()).isEqualTo(9);
        assertThat(craneInstruction.stackTo()).isEqualTo(4);
    }

}