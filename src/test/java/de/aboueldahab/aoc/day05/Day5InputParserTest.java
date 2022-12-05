package de.aboueldahab.aoc.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day5InputParserTest {

    private List<String> exampleInput = Arrays.asList(
            "    [D]    ",
            "[N] [C]    ",
            "[Z] [M] [P]",
            " 1   2   3 ",
            "",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2"
    );
    private Day5InputParser inputParser;

    @BeforeEach
    void setup() {
        inputParser = new Day5InputParser(exampleInput);
    }

    @Test
    void craneInstructionAreWhatFollowsAfterBlankLine() {
        assertThat(inputParser.getCraneInstructions()).containsExactly(
                "move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2"
        );
    }

    @Test
    void keysForCrateStacksAreCorrect() {
        assertThat(inputParser.determineKeys()).containsExactly(1, 2, 3);
    }

    @Test
    void cargoShipIsCreatedCorrectly() {
        CargoShip cargoShip = inputParser.createInitialCargoShip();
        assertThat(cargoShip.getStack(1).getStack()).containsExactly("Z", "N");
        assertThat(cargoShip.getStack(2).getStack()).containsExactly("M", "C", "D");
        assertThat(cargoShip.getStack(3).getStack()).containsExactly("P");
    }

}