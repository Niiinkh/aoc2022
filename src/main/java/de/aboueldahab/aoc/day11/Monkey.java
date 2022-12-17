package de.aboueldahab.aoc.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {

    private List<Item> items = new ArrayList<>();
    private MonkeyBehaviour behaviour;
    private MonkeyOperation operation;
    private Monkey monkeyIfTestFails;
    private Monkey monkeyIfTestSucceeds;
    private Integer index;

    public void handleItem(Item item) {
        operation.executeWithRelief(item);
        if (behaviour.test(item)) {
            throwTo(monkeyIfTestSucceeds, item);
        } else {
            throwTo(monkeyIfTestFails, item);
        }
    }

    private void throwTo(Monkey monkey, Item item) {
        items.remove(item);
        monkey.addItem(item);
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void setBehaviour(MonkeyBehaviour behaviour) {
        this.behaviour = behaviour;
    }

    public void setOperation(MonkeyOperation operation) {
        this.operation = operation;
    }

    public void setMonkeyIfTestFails(Monkey monkeyIfTestFails) {
        this.monkeyIfTestFails = monkeyIfTestFails;
    }

    public void setMonkeyIfTestSucceeds(Monkey monkeyIfTestSucceeds) {
        this.monkeyIfTestSucceeds = monkeyIfTestSucceeds;
    }

    public List<Item> items() {
        return items;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MonkeyBehaviour behaviour() {
        return behaviour;
    }

    public MonkeyOperation operation() {
        return operation;
    }
}
