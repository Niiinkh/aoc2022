package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTest {

    private Monkey monkey;

    @BeforeEach
    void setup() {
        monkey = new Monkey();
    }

    @Test
    void itemsCanBeAddedToMonkey() {
        Item item = new Item(4);
        monkey.addItem(item);
        assertThat(monkey.items()).containsExactly(item);
    }


    @Test
    void monkeyStartsWithActivityCountZero() {
        assertThat(monkey.activity()).isEqualTo(0);
    }

    @Test
    void inspectingAnItemIncresesActivityCount() {
        monkey.setOperation(new MonkeyOperation(i -> i));
        monkey.inspectItem(new Item(1));
        assertThat(monkey.activity()).isEqualTo(1);
    }

}