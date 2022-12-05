package de.aboueldahab.aoc.day05;

import java.util.Map;

public class CargoShip {

    private final Map<Integer, Crate> crates;

    public CargoShip(Map<Integer, Crate> crates) {
        this.crates = crates;
    }

    public Crate getCrate(Integer key) {
        return crates.get(key);
    }

    public void moveItem(Integer from, Integer to) {
        String item = crates.get(from).pop();
        crates.get(to).push(item);
    }

}
