package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;

public class NoOpCommand implements Command {

    @Override
    public void execute(Filesystem filesystem) {
        // do nothing
    }
}
