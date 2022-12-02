package de.aboueldahab.aoc.day02.domain;

import java.util.List;

public class Tournament {

    private final List<GameRound> rounds;

    public Tournament(PuzzleInput input) {
        this.rounds = input.getInput();
    }

    public int getTotalScore() {
        return rounds.stream().map(GameRound::calculatePoints).reduce(Integer::sum).orElse(0);
    }

}
