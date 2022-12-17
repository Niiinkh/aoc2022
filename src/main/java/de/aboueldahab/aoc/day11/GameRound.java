package de.aboueldahab.aoc.day11;

import java.util.List;

public class GameRound {

    private final List<Monkey> monkeys;

    public GameRound(List<Monkey> monkeys) {
        this.monkeys = monkeys;
    }

    public void playOneRound() {

    }

    public void handleItem(Monkey monkey, Item item) {
        monkey.operation().executeWithRelief(item);
        if (monkey.behaviour().test(item)) {
            throwTo(monkey, item, monkey.monkeyIdIfTestSucceeds());
        } else {
            throwTo(monkey, item, monkey.monkeyIdIfTestFails());
        }
    }

    private void throwTo(Monkey currentMonkey, Item item, Integer newMonkeyId) {
        currentMonkey.removeItem(item);
        Monkey monkeyToThrowTo = monkeyById(newMonkeyId);
        if (monkeyToThrowTo != null) {
            monkeyToThrowTo.addItem(item);
        }
    }

    protected Monkey monkeyById(Integer id) {
        return monkeys.stream()
                .filter(monkey -> monkey.getIndex() == id)
                .findFirst().orElse(null);
    }

}
