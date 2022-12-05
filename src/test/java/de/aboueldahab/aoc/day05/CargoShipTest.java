package de.aboueldahab.aoc.day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class CargoShipTest {

    private CargoShip cargoShip;
    private Crate crate1;
    private Crate crate2;

    @BeforeEach
    void setup() {
        HashMap<Integer, Crate> crates = new HashMap<>();
        crate1 = new Crate();
        crate2 = new Crate();
        crates.put(1, crate1);
        crates.put(2, crate2);
        cargoShip = new CargoShip(crates);
    }

    @Test
    void testGetterWorksAsExpected() {
        assertThat(cargoShip.getCrate(1)).isEqualTo(crate1);
    }

    @Test
    void singleItemGetsMoved() {
        crate1.push("A");
        crate1.push("B");

        cargoShip.moveItem(1, 2);

        assertThat(cargoShip.getCrate(1).getStack()).singleElement().isEqualTo("A");
        assertThat(cargoShip.getCrate(2).getStack()).singleElement().isEqualTo("B");
    }

}