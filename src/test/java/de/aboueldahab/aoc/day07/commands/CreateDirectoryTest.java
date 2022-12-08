package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateDirectoryTest {

    @Test
    void directoryIsAddedToCurrentDirectory() {
        Filesystem filesystem = new Filesystem();
        filesystem.execute(new CreateDirectory("abc"));
        assertThat(filesystem.currentDirectory().subdirectories()).singleElement().satisfies(
                dir -> assertThat(dir.path()).isEqualTo("abc")
        );
    }

}