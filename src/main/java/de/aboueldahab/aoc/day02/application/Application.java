package de.aboueldahab.aoc.day02.application;

import de.aboueldahab.aoc.day02.adapter.FileInput;
import de.aboueldahab.aoc.day02.domain.Tournament;

public class Application {

    public static void main(String[] args) {
        Tournament tournament = new Tournament(new FileInput());
        System.out.println("--------------");
        System.out.println("Day 2 Solution");
        System.out.println("--------------");
        System.out.println("Part 1 - total score: " + tournament.getTotalScore());
    }

}
