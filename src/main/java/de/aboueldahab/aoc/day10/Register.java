package de.aboueldahab.aoc.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register {

    private int value = 1;
    private int cycle = 0;

    private int signalStrength;

    private List<Integer> criticalCycles = new ArrayList<>(Arrays.asList(20, 60, 100, 140, 180, 220));

    public int value() {
        return value;
    }

    public int cycle() {
        return cycle;
    }

    public void addValue(int value) {
        this.value += value;
    }

    public void execute(Operation operation) {
        cycle += operation.duration();
        if (!criticalCycles.isEmpty() && cycle > criticalCycles.get(0) - 1) {
            signalStrength += criticalCycles.remove(0) * value;
        }
        operation.execute(this);
    }

    public int signalStrength() {
        return signalStrength;
    }

}
