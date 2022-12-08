package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;

public interface Command {

    void execute(Filesystem filesystem);

}
