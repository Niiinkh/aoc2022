package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTest {

    @Test
    void itemsCanBeAddedToMonkey() {
        Monkey monkey = new Monkey();
        Item item = new Item(4);
        monkey.addItem(item);
        assertThat(monkey.items()).containsExactly(item);
    }

}