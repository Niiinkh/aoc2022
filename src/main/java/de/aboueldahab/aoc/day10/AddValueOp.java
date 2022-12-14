package de.aboueldahab.aoc.day10;

public class AddValueOp implements Operation {
    private final int value;

    public AddValueOp(int value) {
        this.value = value;
    }

    @Override
    public int duration() {
        return 2;
    }

    @Override
    public void execute(Register register) {
        register.addValue(value);
    }

    public int value() {
        return value;
    }
}
