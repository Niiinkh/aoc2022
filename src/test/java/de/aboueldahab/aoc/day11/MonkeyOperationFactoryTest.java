package de.aboueldahab.aoc.day11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyOperationFactoryTest {

    private MonkeyOperationFactory factory;

    @BeforeEach
    void setup() {
        factory = new MonkeyOperationFactory();
    }

    @Test
    void multiplicatorOperation() {
        MonkeyOperation operation = factory.createOp("Operation: new = old * 19");
        Item item = new Item(2);
        operation.execute(item);
        assertThat(item.worryLevel()).isEqualTo(38);
    }

    @Test
    void powerOfTwoOperation() {
        MonkeyOperation operation = factory.createOp("Operation: new = old * old");
        Item item = new Item(7);
        operation.execute(item);
        assertThat(item.worryLevel()).isEqualTo(49);
    }

    @Test
    void minusOperation() {
        MonkeyOperation operation = factory.createOp("Operation: new = old - 7");
        Item item = new Item(10);
        operation.execute(item);
        assertThat(item.worryLevel()).isEqualTo(3);
    }

    @Test
    void plusOperation() {
        MonkeyOperation operation = factory.createOp("Operation: new = old + 7");
        Item item = new Item(10);
        operation.execute(item);
        assertThat(item.worryLevel()).isEqualTo(17);
    }

}