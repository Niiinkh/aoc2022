package de.aboueldahab.aoc.day10;

public class NoOp implements Operation {

    @Override
    public int duration() {
        return 1;
    }

    @Override
    public void execute(Register register) {
        // do nothing
    }
}
