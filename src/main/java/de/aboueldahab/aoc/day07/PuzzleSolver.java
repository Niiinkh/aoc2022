package de.aboueldahab.aoc.day07;

import de.aboueldahab.aoc.common.AocFileReader;

import java.util.List;

public class PuzzleSolver {

    public static void main(String[] args) {
        List<String> input = new AocFileReader().readInput("input_day07.txt");
        System.out.println("--------------");
        System.out.println("Day 7 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - sum of all directories < 100.000: " + getPart1Solution(input));
        System.out.println("Part 2 - smallest directory to delete: " + getPart2Solution(input));
    }

    protected static long getPart1Solution(List<String> signal) {
        Filesystem filesystem = createFilesystem(signal);
        return new TreeSearch().depthFirst(filesystem.root()).stream()
                .map(Directory::size)
                .filter(size -> size < 100000)
                .reduce(Long::sum).orElse(0L);
    }

    protected static long getPart2Solution(List<String> signal) {
        Filesystem filesystem = createFilesystem(signal);
        return new TreeSearch().depthFirst(filesystem.root()).stream()
                .map(Directory::size)
                .filter(size -> size > 30_000_000 - filesystem.freeSpace())
                .sorted().findFirst().orElse(0L);
    }

    private static Filesystem createFilesystem(List<String> signal) {
        CommandParser commandParser = new CommandParser();
        Filesystem filesystem = new Filesystem();
        signal.stream()
                .map(commandParser::parseCommand)
                .forEach(command -> filesystem.execute(command));
        return filesystem;
    }

}
