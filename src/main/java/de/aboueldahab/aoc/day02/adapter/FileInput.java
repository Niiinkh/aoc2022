package de.aboueldahab.aoc.day02.adapter;

import de.aboueldahab.aoc.common.AocFileReader;
import de.aboueldahab.aoc.day02.domain.GameRound;
import de.aboueldahab.aoc.day02.domain.PuzzleInput;

import java.util.List;

public class FileInput implements PuzzleInput {

    private AocFileReader fileReader;

    public FileInput(AocFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<GameRound> getInput() {
        List<String> input = fileReader.readInput("input_day02.txt");
        return new RockPaperScissorParser().convert(input);
    }
}
