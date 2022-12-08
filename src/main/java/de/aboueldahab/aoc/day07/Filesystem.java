package de.aboueldahab.aoc.day07;

import de.aboueldahab.aoc.day07.commands.Command;

public class Filesystem {

    private final Directory root;
    private static final long SIZE = 70_000_000;
    private Directory currentDirectory;

    public Filesystem() {
        root = new Directory("/");
        currentDirectory = root;
    }

    public Directory root() {
        return root;
    }

    public Directory currentDirectory() {
        return currentDirectory;
    }

    public void resetCurrentDirectory() {
        currentDirectory = root;
    }

    public void goUp() {
        if (currentDirectory == root) {
            return;
        }
        currentDirectory = currentDirectory.parent();
    }

    public void goTo(String path) {
        for (Directory subdirectory : currentDirectory.subdirectories()) {
            if (subdirectory.path().equals(path)) {
                currentDirectory = subdirectory;
                return;
            }
        }
    }

    public void execute(Command command) {
        command.execute(this);
    }

    public long freeSpace() {
        return SIZE - root().size();
    }

}
