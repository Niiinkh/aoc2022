package de.aboueldahab.aoc.day07;

import de.aboueldahab.aoc.day07.commands.*;

public class CommandParser {

    public Command parseCommand(String input) {
        if (input.startsWith("$ cd")) {
            return new ChangeDirectory(input.split(" ")[2]);
        }
        if (input.startsWith("$ ls")) {
            return new NoOpCommand();
        }
        if (input.startsWith("dir")) {
            return new CreateDirectory(input.split(" ")[1]);
        }
        return new CreateFile(input);
    }
}
