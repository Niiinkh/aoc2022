package de.aboueldahab.aoc.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class CargoShipTest {

    private CargoShip cargoShip;
    private CrateStack stack1;
    private CrateStack stack2;

    @BeforeEach
    void setup() {
        HashMap<Integer, CrateStack> crates = new HashMap<>();
        stack1 = new CrateStack();
        stack2 = new CrateStack();
        crates.put(1, stack1);
        crates.put(2, stack2);
        cargoShip = new CargoShip(crates);
    }

    @Test
    void testGetterWorksAsExpected() {
        assertThat(cargoShip.getStack(1)).isEqualTo(stack1);
    }

    @Test
    void singleItemGetsMoved() {
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");

        cargoShip.moveCrate(1, 2);

        assertThat(cargoShip.getStack(1).getStack()).containsExactly("A", "B");
        assertThat(cargoShip.getStack(2).getStack()).containsExactly("C");
    }

    @Test
    void rearrangementReverseORder() {
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");
        stack1.push("D");
        stack1.push("E");

        cargoShip.rearrangeReverseOrder(new CraneInstruction("move 3 from 1 to 2"));

        assertThat(cargoShip.getStack(1).getStack()).containsExactly("A", "B");
        assertThat(cargoShip.getStack(2).getStack()).containsExactly("E", "D", "C");
    }

    @Test
    void rearrangementKeepOrder() {
        stack1.push("A");
        stack1.push("B");
        stack1.push("C");
        stack1.push("D");
        stack1.push("E");

        cargoShip.rearrangeKeepOrder(new CraneInstruction("move 3 from 1 to 2"));

        assertThat(cargoShip.getStack(1).getStack()).containsExactly("A", "B");
        assertThat(cargoShip.getStack(2).getStack()).containsExactly("C", "D", "E");
    }

    @Test
    void topItems() {
        stack1.push("Z");
        stack2.push("K");
        assertThat(cargoShip.getTopCrates()).containsExactly("Z", "K");
    }

}