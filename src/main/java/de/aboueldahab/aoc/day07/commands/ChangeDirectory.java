package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;

public class ChangeDirectory implements Command {

    private final String path;

    public ChangeDirectory(String path) {
        this.path = path;
    }

    @Override
    public void execute(Filesystem filesystem) {
        if (path.equals("/")) {
            filesystem.resetCurrentDirectory();
        } else if (path.equals("..")) {
            filesystem.goUp();
        } else {
            filesystem.goTo(path);
        }
    }

    public String path() {
        return path;
    }
}
