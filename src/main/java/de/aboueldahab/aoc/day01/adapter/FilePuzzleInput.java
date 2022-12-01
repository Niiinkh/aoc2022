package de.aboueldahab.aoc.day01.adapter;

import de.aboueldahab.aoc.common.AocFileReader;
import de.aboueldahab.aoc.day01.domain.Elf;
import de.aboueldahab.aoc.day01.domain.PuzzleInputPort;

import java.util.List;

public class FilePuzzleInput implements PuzzleInputPort {

    private AocFileReader fileReader;

    public FilePuzzleInput() {
        this.fileReader = new AocFileReader();
    }

    @Override
    public List<Elf> getElves() {
        List<String> input = fileReader.readInput("input_day01.txt");
        return new ElfInputConverter().convert(input);
    }
}
