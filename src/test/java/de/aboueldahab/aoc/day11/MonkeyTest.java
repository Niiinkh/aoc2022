package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyTest {

    private Monkey monkey;
    private Monkey monkeyIfTestFails;
    private Monkey monkeyIfTestSucceeds;
    private MonkeyBehaviour alwaysTrueBehaviour;
    private MonkeyBehaviour alwaysFalseBehaviour;

    @BeforeEach
    void setup() {
        monkey = new Monkey();
        monkeyIfTestFails = new Monkey();
        monkeyIfTestSucceeds = new Monkey();
        monkey.setMonkeyIfTestFails(1);
        monkey.setMonkeyIfTestSucceeds(2);
        monkey.setOperation(new MonkeyOperation(i -> i));
        alwaysTrueBehaviour = new MonkeyBehaviour(1);
        alwaysFalseBehaviour = new MonkeyBehaviour(123);
        monkey.setBehaviour(alwaysTrueBehaviour);
    }

    @Test
    void itemsCanBeAddedToMonkey() {
        Item item = new Item(4);
        monkey.addItem(item);
        assertThat(monkey.items()).containsExactly(item);
    }

    @Test
    void operationWithReliefGetsExecutedOnItem() {
        Item item = new Item(5);
        monkey.setOperation(new MonkeyOperation(i -> (i + 2) * 3));
        monkey.handleItem(item);
        assertThat(item.worryLevel()).isEqualTo(7);
    }

    @Test
    void itemIsRemovedFromMonkeyWhoHasBeenHoldingIt() {
        Item item = new Item(5);
        monkey.addItem(item);
        monkey.handleItem(item);
        assertThat(monkey.items()).isEmpty();
    }

    @Test
    @Disabled
    void itemIsThrownToCorrectMonkeyIfTestSucceeds() {
        Item item = new Item(5);
        monkey.setBehaviour(alwaysTrueBehaviour);
        monkey.handleItem(item);
        assertThat(monkeyIfTestSucceeds.items()).containsExactly(item);
        assertThat(monkeyIfTestFails.items()).isEmpty();
    }

    @Test
    @Disabled
    void itemIsThrownToCorrectMonkeyIfTestFails() {
        Item item = new Item(5);
        monkey.setBehaviour(alwaysFalseBehaviour);
        monkey.handleItem(item);
        assertThat(monkeyIfTestSucceeds.items()).isEmpty();
        assertThat(monkeyIfTestFails.items()).containsExactly(item);
    }

}