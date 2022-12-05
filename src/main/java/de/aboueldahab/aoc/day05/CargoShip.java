package de.aboueldahab.aoc.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CargoShip {

    private final Map<Integer, CrateStack> stack;

    public CargoShip(Map<Integer, CrateStack> stack) {
        this.stack = stack;
    }

    public CrateStack getStack(Integer key) {
        return stack.get(key);
    }

    public void rearrangeReverseOrder(CraneInstruction instruction) {
        for (int i = 0; i < instruction.itemCount(); i++) {
            moveCrate(instruction.stackFrom(), instruction.stackTo());
        }
    }

    public void rearrangeKeepOrder(CraneInstruction instruction) {
        CrateStack stackFrom = stack.get(instruction.stackFrom());
        CrateStack stackTo = stack.get(instruction.stackTo());

        List<String> cratesToMove = new ArrayList<>();
        for (int i = 0; i < instruction.itemCount(); i++) {
            cratesToMove.add(stackFrom.pop());
        }
        Collections.reverse(cratesToMove);
        cratesToMove.forEach(crate -> stackTo.push(crate));
    }

    protected void moveCrate(Integer from, Integer to) {
        String crate = stack.get(from).pop();
        stack.get(to).push(crate);
    }

    public List<String> getTopCrates() {
        return stack.values().stream().map(stack -> stack.peek()).collect(Collectors.toList());
    }
}
