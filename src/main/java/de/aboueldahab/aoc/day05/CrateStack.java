package de.aboueldahab.aoc.day05;

import java.util.Stack;

public class CrateStack {

    private final Stack<String> stack = new Stack<>();

    public String pop() {
        return stack.pop();
    }

    public void push(String item) {
        stack.push(item);
    }

    protected Stack<String> getStack() {
        return stack;
    }

    public String peek() {
        return stack.peek();
    }
}
