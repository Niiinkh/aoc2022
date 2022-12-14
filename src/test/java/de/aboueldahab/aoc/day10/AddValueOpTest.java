package de.aboueldahab.aoc.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddValueOpTest {

    private Register register;

    @BeforeEach
    void setup() {
        register = new Register();
    }

    @Test
    void durationIsTwo() {
        assertThat(new AddValueOp(1).duration()).isEqualTo(2);
    }

    @Test
    void valueIsBeingAdded() {
        AddValueOp addValueOp = new AddValueOp(3);
        addValueOp.execute(register);
        assertThat(register.value()).isEqualTo(4);
    }

}