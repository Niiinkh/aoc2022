package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Directory;
import de.aboueldahab.aoc.day07.Filesystem;

public class CreateDirectory implements Command {

    private final String directoryPath;

    public CreateDirectory(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public void execute(Filesystem filesystem) {
        filesystem.currentDirectory().addSubdirectory(new Directory(directoryPath));
    }
}
