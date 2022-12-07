package de.aboueldahab.aoc.day07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DirectoryTest {

    private Directory directory;

    @BeforeEach
    void setup() {
        directory = new Directory("dirName");
    }

    @Test
    void newDirectoryHasNoFiles() {
        assertThat(directory.files()).isEmpty();
    }

    @Test
    void filesCanBeAddedToDirectory() {
        AocFile fileA = new AocFile();
        AocFile fileB = new AocFile();
        directory.addFile(fileA);
        directory.addFile(fileB);
        assertThat(directory.files()).containsExactly(fileA, fileB);
    }

    @Test
    void newDirectoryHasNoParent() {
        assertThat(directory.parent()).isNull();
    }

    @Test
    void parentCanBeAdded() {
        Directory parent = new Directory("b");
        directory.setParent(parent);
        assertThat(directory.parent()).isEqualTo(parent);
    }

    @Test
    void childDirectoryIsAddedWhenAssigningParent() {
        Directory parent = new Directory("parent");
        Directory subdirectory = new Directory("subdirectory");
        subdirectory.setParent(parent);
        assertThat(parent.subdirectories()).containsExactly(subdirectory);
    }

    @Test
    void newDirectoryHasNoSubdirectories() {
        assertThat(directory.subdirectories()).isEmpty();
    }

    @Test
    void subdirectoriesCanBeAdded() {
        Directory parent = new Directory("parent");
        Directory subA = new Directory("subA");
        Directory subB = new Directory("subB");
        parent.addSubdirectory(subA);
        parent.addSubdirectory(subB);
        assertThat(parent.subdirectories()).containsExactlyInAnyOrder(subA, subB);
    }

    @Test
    void parentDirectoryIsSetAutomaticallyWhenAddingChild() {
        Directory parent = new Directory("parent");
        Directory subdirectory = new Directory("subdirectory");
        parent.addSubdirectory(subdirectory);
        assertThat(subdirectory.parent()).isEqualTo(parent);
    }
}