package de.aboueldahab.aoc.day11;

import de.aboueldahab.aoc.common.AocFileReader;
import de.aboueldahab.aoc.day10.OperationParser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PuzzleSolver {

    private static final OperationParser opParser = new OperationParser();

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day11.txt");
        System.out.println("--------------");
        System.out.println("Day 11 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - two most active monkeys: " + getPart1Solution(input));
    }

    protected static long getPart1Solution(List<String> input) {
        List<Monkey> monkeys = new InitialGameRoundParser().parseAllMonkeys(input);
        GameRound gameRound = new GameRound(monkeys);
        gameRound.playTwentyRounds();
        monkeys.sort(Comparator.comparing(Monkey::activity));
        Collections.reverse(monkeys);
        return monkeys.get(0).activity() * monkeys.get(1).activity();
    }

}
