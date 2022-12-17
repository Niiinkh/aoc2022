package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InitialGameRoundParserTest {

    private final List<String> monkeyExample = Arrays.asList(
            "Monkey 0:",
            "  Starting items: 79, 98",
            "  Operation: new = old * 19",
            "  Test: divisible by 23",
            "    If true: throw to monkey 2",
            "    If false: throw to monkey 3");
    private InitialGameRoundParser gameRoundParser;

    @BeforeEach
    void setup() {
        gameRoundParser = new InitialGameRoundParser();
    }

    @Test
    void monkeyHasIndex() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        assertThat(monkey.getIndex()).isEqualTo(0);
    }

    @Test
    void monkeyHasExpectedItems() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        assertThat(monkey.items()).hasSize(2);
        assertThat(monkey.items().get(0).worryLevel()).isEqualTo(79);
        assertThat(monkey.items().get(1).worryLevel()).isEqualTo(98);
    }

    @Test
    void monkeyHasExpectedBehaviour() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        assertThat(monkey.behaviour().divisibleBy()).isEqualTo(23);
    }

    @Test
    void monkeyHasOperation() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        Item item = new Item(2);
        monkey.operation().execute(item);
        assertThat(item.worryLevel()).isEqualTo(38);
    }

    @Test
    void monkeyKnowsMonkeyToThrowToIfTestSucceeds() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        assertThat(monkey.monkeyIdIfTestSucceeds()).isEqualTo(2);
    }

    @Test
    void monkeyKnowsMonkeyToThrowToIfTestFails() {
        Monkey monkey = gameRoundParser.parseMonkey(monkeyExample);
        assertThat(monkey.monkeyIdIfTestFails()).isEqualTo(3);
    }

}