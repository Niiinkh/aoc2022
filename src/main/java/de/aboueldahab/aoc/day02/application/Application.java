package de.aboueldahab.aoc.day02.application;

import de.aboueldahab.aoc.day02.adapter.FileInput;
import de.aboueldahab.aoc.day02.domain.Tournament;

public class Application {

    public static void main(String[] args) {
        FileInput fileInput = new FileInput();
        Tournament tournamentPart1 = new Tournament(fileInput.getInputForPart1());
        Tournament tournamentPart2 = new Tournament(fileInput.getInputForPart2());
        System.out.println("--------------");
        System.out.println("Day 2 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - total score: " + tournamentPart1.getTotalScore());
        System.out.println("Part 2 - total score: " + tournamentPart2.getTotalScore());
    }

}
