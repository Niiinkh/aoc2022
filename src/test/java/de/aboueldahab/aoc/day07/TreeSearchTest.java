package de.aboueldahab.aoc.day07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TreeSearchTest {

    private TreeSearch treeSearch;
    private Directory root;
    private Directory dirA;
    private Directory dirB;
    private Directory dirC;
    private Directory dirD;
    private Directory dirE;
    private Directory dirF;

    @BeforeEach
    void setup() {
        treeSearch = new TreeSearch();
        root = new Directory("root");
        dirA = new Directory("A");
        dirB = new Directory("B");
        dirC = new Directory("C");
        dirD = new Directory("D");
        dirE = new Directory("E");
        dirF = new Directory("F");
    }

    @Test
    void noChildren_onlyRootDirectory() {
        List<Directory> directories = treeSearch.depthFirst(root);
        assertThat(directories).containsExactly(root);
    }

    @Test
    void oneLevelOfChildren() {
        root.addSubdirectory(dirA);
        root.addSubdirectory(dirB);
        List<Directory> directories = treeSearch.depthFirst(root);
        assertThat(directories).containsExactly(root, dirA, dirB);
    }

    @Test
    void multipleLevelOfChildren() {
        root.addSubdirectory(dirA);
        root.addSubdirectory(dirB);
        dirA.addSubdirectory(dirC);
        dirC.addSubdirectory(dirD);
        dirC.addSubdirectory(dirE);
        dirB.addSubdirectory(dirF);
        List<Directory> directories = treeSearch.depthFirst(root);
        assertThat(directories).containsExactly(root, dirA, dirC, dirD, dirE, dirB, dirF);
    }

}