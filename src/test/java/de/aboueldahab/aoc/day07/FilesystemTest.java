package de.aboueldahab.aoc.day07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FilesystemTest {

    private Filesystem filesystem;

    @BeforeEach
    void setup() {
        filesystem = new Filesystem();
    }

    @Test
    void outermostDirectoryHasCorrectPath() {
        assertThat(filesystem.root().path()).isEqualTo("/");
    }

    @Test
    void initialCurrentDirectoryIsRoot() {
        assertThat(filesystem.currentDirectory()).isEqualTo(filesystem.root());
    }

    @Test
    void goTo_noneExistingPathHasNoEffect() {
        Directory subdirectory = new Directory("path");
        filesystem.root().addSubdirectory(subdirectory);
        filesystem.goTo("paaaaath");
        assertThat(filesystem.currentDirectory()).isEqualTo(filesystem.root());
    }

    @Test
    void goTo_pathExists() {
        Directory subdirectory = new Directory("path");
        filesystem.root().addSubdirectory(subdirectory);
        filesystem.goTo("path");
        assertThat(filesystem.currentDirectory()).isEqualTo(subdirectory);
    }

    @Test
    void goTo_canGoMultipleLevelsDeep() {
        Directory root = filesystem.root();
        Directory level1 = new Directory("level1");
        Directory level2 = new Directory("level2");
        root.addSubdirectory(level1);
        level1.addSubdirectory(level2);
        filesystem.goTo("level1");
        filesystem.goTo("level2");
        assertThat(filesystem.currentDirectory()).isEqualTo(level2);
    }


    @Test
    void goUp_noEffectOnRoot() {
        Directory subdirectory = new Directory("path");
        filesystem.root().addSubdirectory(subdirectory);
        filesystem.goTo("paaaaath");
        assertThat(filesystem.currentDirectory()).isEqualTo(filesystem.root());
    }

    @Test
    void goUp_goesUpOtherwise() {
        Directory root = filesystem.root();
        Directory level1 = new Directory("level1");
        Directory level2 = new Directory("level2");
        root.addSubdirectory(level1);
        level1.addSubdirectory(level2);
        filesystem.goTo("level1");
        filesystem.goTo("level2");

        filesystem.goUp();
        assertThat(filesystem.currentDirectory()).isEqualTo(level1);
    }


    @Test
    void resetCurrentDirectory() {
        Directory root = filesystem.root();
        Directory level1 = new Directory("level1");
        Directory level2 = new Directory("level2");
        root.addSubdirectory(level1);
        level1.addSubdirectory(level2);
        filesystem.goTo("level1");
        filesystem.goTo("level2");

        filesystem.resetCurrentDirectory();
        assertThat(filesystem.currentDirectory()).isEqualTo(root);
    }

}