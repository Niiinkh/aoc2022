package de.aboueldahab.aoc.day11;

import java.util.ArrayList;
import java.util.List;

public class GameRound {

    private final List<Monkey> monkeys;

    public GameRound(List<Monkey> monkeys) {
        this.monkeys = monkeys;
    }

    public void playTwentyRounds() {
        for (int i = 0; i < 20; i++) {
            playOneRound();
        }
    }

    public void playOneRound() {
        monkeys.forEach(monkey -> {
            monkey.items().forEach(item -> handleItem(monkey, item));
            monkey.setItems(new ArrayList<>());
        });
    }

    public void handleItem(Monkey monkey, Item item) {
        monkey.inspectItem(item);
        if (monkey.behaviour().test(item)) {
            throwTo(monkey, item, monkey.monkeyIdIfTestSucceeds());
        } else {
            throwTo(monkey, item, monkey.monkeyIdIfTestFails());
        }
    }

    private void throwTo(Monkey currentMonkey, Item item, Integer newMonkeyId) {
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

    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
