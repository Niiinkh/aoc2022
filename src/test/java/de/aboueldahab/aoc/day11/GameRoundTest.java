package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundTest {

    private Monkey monkey1;
    private Monkey monkey2;
    private Monkey monkey3;
    private List<Monkey> monkeys;
    private MonkeyBehaviour alwaysTrueBehaviour = new MonkeyBehaviour(1);
    private MonkeyBehaviour alwaysFalseBehaviour = new MonkeyBehaviour(123);
    private GameRound gameRound;

    @BeforeEach
    void setup() {
        monkey1 = new Monkey();
        monkey1.setIndex(1);
        monkey1.setOperation(new MonkeyOperation(i -> i));
        monkey1.setBehaviour(alwaysTrueBehaviour);
        monkey2 = new Monkey();
        monkey2.setIndex(2);
        monkey3 = new Monkey();
        monkey3.setIndex(3);
        monkeys = Arrays.asList(monkey1, monkey2, monkey3);
        gameRound = new GameRound(monkeys);
    }

    @Test
    void monkeyByIdReturnsCorrectMonkey() {
        assertThat(gameRound.monkeyById(2)).isEqualTo(monkey2);
    }

    @Test
    void operationWithReliefGetsExecutedOnItem() {
        Item item = new Item(5);
        monkey1.setOperation(new MonkeyOperation(i -> (i + 2) * 3));
        gameRound.handleItem(monkey1, item);
        assertThat(item.worryLevel()).isEqualTo(7);
    }

    @Test
    void itemIsThrownToCorrectMonkeyIfTestSucceeds() {
        Item item = new Item(5);
        monkey1.setBehaviour(alwaysTrueBehaviour);
        monkey1.setMonkeyIfTestSucceeds(2);
        monkey1.setMonkeyIfTestFails(3);
        gameRound.handleItem(monkey1, item);
        assertThat(monkey2.items()).containsExactly(item);
        assertThat(monkey3.items()).isEmpty();
    }

    @Test
    void itemIsThrownToCorrectMonkeyIfTestFails() {
        Item item = new Item(5);
        monkey1.setBehaviour(alwaysFalseBehaviour);
        monkey1.setMonkeyIfTestSucceeds(2);
        monkey1.setMonkeyIfTestFails(3);
        gameRound.handleItem(monkey1, item);
        assertThat(monkey2.items()).isEmpty();
        assertThat(monkey3.items()).containsExactly(item);
    }

    @Test
    void playingOneRoundOnExampleInput() {
        List<Monkey> exampleInput = new InitialGameRoundParser().parseAllMonkeys(PuzzleSolverTest.exampleInput());
        GameRound gameRound = new GameRound(exampleInput);
        gameRound.playOneRound();
        assertThat(exampleInput.get(0).items()).hasSize(4);
        assertThat(exampleInput.get(1).items()).hasSize(6);
        assertThat(exampleInput.get(2).items()).isEmpty();
        assertThat(exampleInput.get(3).items()).isEmpty();
    }

}