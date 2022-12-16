package de.aboueldahab.aoc.day11;

public class MonkeyOperationFactory {

    public MonkeyOperation createOp(String input) {
        String[] split = input.trim().split(" ");
        String operator = split[4];
        String secondArg = split[5];
        if (secondArg.equals("old")) {
            return new MonkeyOperation(i -> i * i);
        }
        int number = Integer.parseInt(secondArg);
        switch (operator) {
            case "*":
                return new MonkeyOperation(i -> i * number);
            case "-":
                return new MonkeyOperation(i -> i - number);
            case "+":
                return new MonkeyOperation(i -> i + number);
        }
        throw new IllegalArgumentException("Could not create operation from: " + input);
    }


}
