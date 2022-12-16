package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyOperationTest {


    @Test
    void functionGetsExecutedOnWorryLevel() {
        MonkeyOperation operation = new MonkeyOperation(i -> i + 100);
        Item item = new Item(12);
        operation.execute(item);
        assertThat(item.worryLevel()).isEqualTo(112);
    }

    @Test
    void reliefReducesWorryLevelToOneThird() {
        MonkeyOperation noOp = new MonkeyOperation(i -> i);
        Item item = new Item(15);
        noOp.executeWithRelief(item);
        assertThat(item.worryLevel()).isEqualTo(5);
    }

    @Test
    void reliefReducesWorryLevelAndRoundsDown() {
        MonkeyOperation noOp = new MonkeyOperation(i -> i);
        Item item = new Item(14);
        noOp.executeWithRelief(item);
        assertThat(item.worryLevel()).isEqualTo(4);
    }

}