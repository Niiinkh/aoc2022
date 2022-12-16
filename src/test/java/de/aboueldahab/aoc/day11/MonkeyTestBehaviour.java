package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTestBehaviour {


    @Test
    void itemWorryLevelIsDivisible() {
        MonkeyBehaviour monkeyBehaviour = new MonkeyBehaviour(7);
        Item item = new Item(21);
        assertThat(monkeyBehaviour.test(item)).isTrue();
    }

    @Test
    void itemWorryLevelIsNotDivisible() {
        MonkeyBehaviour monkeyBehaviour = new MonkeyBehaviour(7);
        Item item = new Item(22);
        assertThat(monkeyBehaviour.test(item)).isFalse();
    }

}