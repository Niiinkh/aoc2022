package de.aboueldahab.aoc.day11;

import java.util.ArrayList;
import java.util.List;

public class InitialGameRoundParser {

    public List<Monkey> parseAllMonkeys(List<String> exampleInput) {
        List<Monkey> monkeys = new ArrayList<>();
        List<String> rawMonkey = new ArrayList<>();
        for (String line : exampleInput) {
            if (line.isBlank()) {
                monkeys.add(parseMonkey(rawMonkey));
                rawMonkey = new ArrayList<>();
                continue;
            }
            rawMonkey.add(line);
        }
        monkeys.add(parseMonkey(rawMonkey));
        return monkeys;
    }

    public Monkey parseMonkey(List<String> input) {
        Monkey monkey = new Monkey();
        monkey.setIndex(parseIndex(input));
        monkey.setItems(parseItems(input));
        monkey.setBehaviour(parseBehaviour(input));
        monkey.setOperation(parseOperation(input));
        monkey.setMonkeyIfTestSucceeds(parseMonkeyId(input.get(4)));
        monkey.setMonkeyIfTestFails(parseMonkeyId(input.get(5)));
        return monkey;
    }

    private int parseIndex(List<String> input) {
        return Integer.parseInt(input.get(0).split(" ")[1].replace(":", ""));
    }

    private List<Item> parseItems(List<String> input) {
        String spaceSeperatedNumbers = input.get(1)
                .replaceAll(",", "")
                .replace("Starting items:", "")
                .trim();
        List<Item> items = new ArrayList<>();
        for (String worryLevel : spaceSeperatedNumbers.split(" ")) {
            items.add(new Item(Integer.parseInt(worryLevel)));
        }
        return items;
    }

    private MonkeyBehaviour parseBehaviour(List<String> input) {
        int divisibleBy = Integer.parseInt(input.get(3).replace("Test: divisible by", "").trim());
        return new MonkeyBehaviour(divisibleBy);
    }

    private static MonkeyOperation parseOperation(List<String> input) {
        return new MonkeyOperationFactory().createOp(input.get(2));
    }

    private int parseMonkeyId(String line) {
        return Integer.parseInt(line.trim().split(" ")[5]);
    }

}
