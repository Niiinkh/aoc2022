package de.aboueldahab.aoc.day10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegisterTest {

    private Register register;

    @BeforeEach
    void setup() {
        register = new Register();
    }

    @Test
    void initialCycleIsZero() {
        assertThat(register.cycle()).isEqualTo(0);
    }

    @Test
    void initialValueIsOne() {
        assertThat(register.value()).isEqualTo(1);
    }

    @Test
    void addValueIncreasesValue() {
        register.addValue(100);
        assertThat(register.value()).isEqualTo(101);
    }

    @Test
    void addValueDecreasesValue() {
        register.addValue(-5);
        assertThat(register.value()).isEqualTo(-4);
    }

    @Test
    void operationAddsDurationToRegister() {
        register.execute(new FakeOperation());
        assertThat(register.cycle()).isEqualTo(3);
    }

    @Test
    void operationExecutes() {
        FakeOperation operation = new FakeOperation();
        assertThat(operation.isExecuted()).isFalse();
        register.execute(operation);
        assertThat(operation.isExecuted()).isTrue();
    }

    class FakeOperation implements Operation {

        boolean isExecuted = false;

        @Override
        public int duration() {
            return 3;
        }

        @Override
        public void execute(Register register) {
            isExecuted = true;
        }

        public boolean isExecuted() {
            return isExecuted;
        }
    }

}