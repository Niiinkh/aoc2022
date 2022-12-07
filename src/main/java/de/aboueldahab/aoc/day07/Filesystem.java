package de.aboueldahab.aoc.day07;

public class Filesystem {

    private final Directory root;
    private final Directory currentDirectory;

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

}
