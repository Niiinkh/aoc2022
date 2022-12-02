package de.aboueldahab.aoc.day02.adapter;

import de.aboueldahab.aoc.common.AocFileReader;
import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.PuzzleInput;

import java.util.List;

public class FileInput implements PuzzleInput {

    private final RockPaperScissorParser parser;
    private List<String> input;

    public FileInput() {
        input = new AocFileReader().readInput("input_day02.txt");
        parser = new RockPaperScissorParser();
    }

    @Override
    public List<GameRound> getInputForPart1() {
        return parser.convertPart1(input);
    }

    @Override
    public List<GameRound> getInputForPart2() {
        return parser.convertPart2(input);
    }
}
