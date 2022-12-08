package de.aboueldahab.aoc.day07;

import de.aboueldahab.aoc.day07.commands.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandParserTest {

    private CommandParser commandParser;

    @BeforeEach
    void setup() {
        commandParser = new CommandParser();
    }

    @Test
    void changeDirectoryCommandGetsCreatedWithCorrectPath() {
        Command command = commandParser.parseCommand("$ cd hhh");
        assertThat(command).isInstanceOfSatisfying(ChangeDirectory.class,
                c -> assertThat(c.path()).isEqualTo("hhh")
        );
    }

    @Test
    void lsRequiresNoOperation() {
        Command command = commandParser.parseCommand("$ ls");
        assertThat(command).isInstanceOf(NoOpCommand.class);
    }

    @Test
    void createDirectoryCommandGetsCorrectPath() {
        Command command = commandParser.parseCommand("dir ttttt");
        assertThat(command).isInstanceOfSatisfying(CreateDirectory.class,
                c -> assertThat(c.path()).isEqualTo("ttttt")
        );
    }

    @Test
    void createFileCommandCreatesFileWithCorrectProperties() {
        Command command = commandParser.parseCommand("584 i");
        assertThat(command).isInstanceOf(CreateFile.class);
        AocFile file = ((CreateFile) command).file();
        assertThat(file.name()).isEqualTo("i");
        assertThat(file.size()).isEqualTo(584);
    }

}