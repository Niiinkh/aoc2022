package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Filesystem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateFileTest {

    @Test
    void fileIsCreatedInCurrentDirectory() {
        Filesystem filesystem = new Filesystem();
        filesystem.execute(new CreateFile("584 i"));
        assertThat(filesystem.currentDirectory().files()).singleElement().satisfies(
                file -> {
                    assertThat(file.name()).isEqualTo("i");
                    assertThat(file.size()).isEqualTo(584);
                }
        );
    }

}