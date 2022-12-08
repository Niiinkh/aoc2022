package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.AocFile;
import de.aboueldahab.aoc.day07.Filesystem;

public class CreateFile implements Command {

    private final AocFile file;

    public CreateFile(String fileInfo) {
        String[] split = fileInfo.split(" ");
        long size = Long.parseLong(split[0]);
        String filename = split[1];
        this.file = new AocFile(filename, size);
    }

    @Override
    public void execute(Filesystem filesystem) {
        filesystem.currentDirectory().addFile(file);
    }
}
