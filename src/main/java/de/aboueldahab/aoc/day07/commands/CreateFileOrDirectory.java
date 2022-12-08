package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;

public class CreateFileOrDirectory implements Command {

    private final String input;

    public CreateFileOrDirectory(String input) {
        this.input = input;
    }

    @Override
    public void execute(Filesystem filesystem) {
        if (input.startsWith("dir")) {
            String directoryPath = input.split(" ")[1];
            new CreateDirectory(directoryPath);
        } else {
            new CreateFile(input);
        }
    }
}
