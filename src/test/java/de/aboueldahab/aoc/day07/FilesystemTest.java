package de.aboueldahab.aoc.day07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FilesystemTest {


    @Test
    void outermostDirectoryHasCorrectPath() {
        assertThat(new Filesystem().root().path()).isEqualTo("/");
    }

    @Test
    void initialCurrentDirectoryIsRoot() {
        Filesystem filesystem = new Filesystem();
        assertThat(filesystem.currentDirectory()).isEqualTo(filesystem.root());
    }

}