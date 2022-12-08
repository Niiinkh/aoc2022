package de.aboueldahab.aoc.day07.commands;

import de.aboueldahab.aoc.day07.Directory;
import de.aboueldahab.aoc.day07.Filesystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChangeDirectoryTest {

    private Filesystem filesystem;
    private Directory dirA;
    private Directory dirB;
    private Directory dirC;

    @BeforeEach
    void setup() {
        filesystem = new Filesystem();
        dirA = new Directory("A");
        dirB = new Directory("B");
        dirC = new Directory("C");
        filesystem.root().addSubdirectory(dirA);
        dirA.addSubdirectory(dirB);
        dirA.addSubdirectory(dirC);
    }

    @Test
    void slashMeansGoToRoot() {
        filesystem.goTo("A");
        filesystem.goTo("B");
        filesystem.execute(new ChangeDirectory("/"));
        assertThat(filesystem.currentDirectory()).isEqualTo(filesystem.root());
    }

    @Test
    void dotsMeansGoOneUp() {
        filesystem.goTo("A");
        filesystem.goTo("B");
        filesystem.execute(new ChangeDirectory(".."));
        assertThat(filesystem.currentDirectory()).isEqualTo(dirA);
    }

    @Test
    void anythingElseMeansGoDownToSpecifiedDirectory() {
        filesystem.execute(new ChangeDirectory("A"));
        assertThat(filesystem.currentDirectory()).isEqualTo(dirA);
    }

}