package de.aboueldahab.aoc.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperationParserTest {

    private OperationParser operationParser;

    @BeforeEach
    void setup() {
        operationParser = new OperationParser();
    }

    @Test
    void noopIsOfCorrectType() {
        assertThat(operationParser.parseInput("noop")).isInstanceOf(NoOp.class);
    }

    @Test
    void addValueOpIsOfCorrectType() {
        assertThat(operationParser.parseInput("addx 1")).isInstanceOf(AddValueOp.class);
    }

    @Test
    void addValueOpHasCorrectValue() {
        Operation operation = operationParser.parseInput("addx 12");
        assertThat(((AddValueOp) operation).value()).isEqualTo(12);
    }

    @Test
    void unknownOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> operationParser.parseInput("unknown operation"));
    }


}