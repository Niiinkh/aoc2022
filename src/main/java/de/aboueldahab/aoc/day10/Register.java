package de.aboueldahab.aoc.day10;

public class Register {

    private int value = 1;
    private int cycle = 0;

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
        operation.execute(this);
    }

}
