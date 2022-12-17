package de.aboueldahab.aoc.day11;

import java.util.ArrayList;
import java.util.List;

public class Monkey {

    private List<Item> items = new ArrayList<>();
    private MonkeyBehaviour behaviour;
    private MonkeyOperation operation;
    private Integer monkeyIdIfTestFails;
    private Integer monkeyIdIfTestSucceeds;
    private Integer index;

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

    public void setMonkeyIfTestFails(int monkeyId) {
        this.monkeyIdIfTestFails = monkeyId;
    }

    public void setMonkeyIfTestSucceeds(int monkeyId) {
        this.monkeyIdIfTestSucceeds = monkeyId;
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

    public Integer monkeyIdIfTestSucceeds() {
        return monkeyIdIfTestSucceeds;
    }

    public Integer monkeyIdIfTestFails() {
        return monkeyIdIfTestFails;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
