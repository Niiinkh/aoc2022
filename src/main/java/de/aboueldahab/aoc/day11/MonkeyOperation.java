package de.aboueldahab.aoc.day11;

import java.util.function.Function;

public class MonkeyOperation {

    private final Function<Integer, Integer> function;

    public MonkeyOperation(Function<Integer, Integer> function) {
        this.function = function;
    }

    public void execute(Item item) {
        executeFunction(item, this.function);
    }

    private static void executeFunction(Item item, Function<Integer, Integer> function) {
        item.setWorryLevel(function.apply(item.worryLevel()));
    }

    public void executeWithRelief(Item item) {
        execute(item);
        executeFunction(item, i -> i / 3);
    }

}
